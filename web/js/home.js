
function openPostForm() {
    document.getElementById("myForm").style.display = "block";
}

function closePostForm() {
    document.getElementById("myForm").style.display = "none";
}

async function newPost() {
    var form = document.getElementById("newpost");
    var body = form.elements.body.value;

    fetch('http://localhost:4567/post',{
        method: 'POST',
        mode: 'cors',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            username: 'Jason',
            postType: 'Question',
            content: body,
            likes: 0,
            tags: 'tags'})
    }).then(function (response) {
        // The API call was successful!
        return response.json();
    }).then(function (data) {
        // This is the JSON from our response
        console.log(data);
    }).catch(function (err) {
        // There was an error
        console.warn('Something went wrong.', err);
    });
}


function closeMyPosts() {
    //document.getElementById("mypostscontainer").style.display = "none";
    let allposts = document.getElementById('mypostscontainer');
    while (allposts.firstChild) {
        allposts.removeChild(allposts.firstChild);
    }
}

function showMyPosts() {
    document.getElementById("mypostscontainer").style.display = "block";
}

async function getMyPosts() {
    var username = "Jason";
    fetch('http://localhost:4567/posts/'+username).then(function (response) {
        // The API call was successful!
        return response.json();
    }).then(function (data) {
        // This is the JSON from our response
        //console.log(data);
        //displayMyPosts(data);
        for (let i = 0; i < data.length; i++) {
            displayPost(data[i])
        }
    }).catch(function (err) {
        // There was an error
        console.warn('Something went wrong.', err);
    });
}

function displayPost(data) {
    showMyPosts();
    console.log(data);
    let postdiv = document.createElement('div');
    postdiv.setAttribute('class','post-overlay');
    //postdiv.setAttribute('id','postdiv');
    document.getElementById('mypostscontainer').appendChild(postdiv);
    // timestamp
    let posttimediv = document.createElement('div');
    posttimediv.setAttribute('class','posttime');
    postdiv.appendChild(posttimediv);
    let posttimestamp = document.createTextNode(data.timestamp);
    posttimediv.appendChild(posttimestamp);
    // username
    let postusernamediv = document.createElement('div');
    postusernamediv.setAttribute('class','postusername');
    postdiv.appendChild(postusernamediv);
    let postusername = document.createTextNode(data.username + " asks:");
    postusernamediv.appendChild(postusername);
    // question
    let postcontentdiv = document.createElement('div');
    postcontentdiv.setAttribute('class','postcontent');
    postdiv.appendChild(postcontentdiv);
    let postquestion = document.createTextNode(data.content);
    postcontentdiv.appendChild(postquestion);
    // view answers
    let answerbtn = document.createElement('button');
    answerbtn.setAttribute('class','postanswer-btn');
    answerbtn.innerHTML = "View Answers";
    // //answerbtn.addEventListener('click', getMyPostsAnswers(data.id));
    // answerbtn.addEventListener('click', function() {
    //     fetch('http://localhost:4567/answers/'+askPostID).then(function (response) {
    //         // The API call was successful!
    //         return response.json();
    //     }).then(function (data) {
    //         console.log(data);
    //         for (let i = 0; i < data.length; i++) {
    //             showMyPostsAnswers(data[i]);
    //         }
    //     }).catch(function (err) {
    //         // There was an error
    //         console.warn('Something went wrong.', err);
    //     });
    // });
    // postdiv.appendChild(answerbtn);
}

// function getMyPostsAnswers(askPostID) {
//     fetch('http://localhost:4567/answers/'+askPostID).then(function (response) {
//         // The API call was successful!
//         return response.json();
//     }).then(function (data) {
//         console.log(data);
//         for (let i = 0; i < data.length; i++) {
//             showMyPostsAnswers(data[i]);
//         }
//     }).catch(function (err) {
//         // There was an error
//         console.warn('Something went wrong.', err);
//     });
// }

// async function getPost(askPostID) {
//     let response = await fetch('http://localhost:4567/post/'+askPostID);
//     return await response.json();
// }

// let testvar = getPost('1').then(data=>console.log(data));
// console.log(testvar);

// async function getAnswer(answerID) {
//     const response = await fetch('http://localhost:4567/answer/'+answerID);
//     return await response.json();
// }



function getPost(askPostID){
    return new Promise((resolve, reject) => {
        fetch('http://localhost:4567/post/'+askPostID)
            .then(response=> {
                return response.json();
            }).then(data => {
                //console.log(data);
                resolve(data);
        })
    })
}
let question = '';
getPost(1).then(data => {
    question = data;
    //console.log(question);
});
console.log(question);

async function getMockInterviews() {
    const mockintid = 1;
    fetch('http://localhost:4567/mockinterview/'+mockintid).then(function (response) {
        // The API call was successful!
        return response.json();
    }).then(function (data) {
        // This is the JSON from our response
        document.getElementById(mockintid.toString()).value=data.name;
        showMockInterviewNav();
        // console.log(data);
    }).catch(function (err) {
        // There was an error
        console.warn('Something went wrong.', err);
    });
}

function showMockInterviewNav() {
    document.getElementById("mockintnav").style.display = "block";
}

function closeMockInterviewNav() {
    document.getElementById("mockintnav").style.display = "none";
}

function Post(content) {
    this.content = content;
}
function Answer(content) {
    this.content = content;
}

async function showMockInterview(mockintid) {
    closeMockInterviewNav();
    let questions = [];
    let answers = [];
    fetch('http://localhost:4567/mockinterview/'+mockintid).then(function (response) {
        // The API call was successful!
        return response.json();
    }).then(function (data) {
        // This is the JSON from our response
        showMockInterviewOverlay();
        document.getElementById("mockint-name").innerHTML=data.name;
        let posts = "askPostIDs";
        let askPostIDs = data[posts];
        let ans = "answerIDs";
        let answerIDs = data[ans];
        let content = "content";
        for (let ii = 0; ii < askPostIDs.length; ii++) {
            let askPostID = askPostIDs[ii];
            let answerID = answerIDs[ii];
            fetch('http://localhost:4567/post/'+askPostID ).then(function (response) {
                // The API call was successful!
                return response.json();
            }).then(function (post) {
                questions[ii] = post.content;
                //console.log(questions[0].content);
                fetch('http://localhost:4567/answer/'+answerID ).then(function (response) {
                    // The API call was successful!
                    return response.json();
                }).then(function (answer) {
                    answers[ii] = answer.content;
                    let questionholder = document.getElementById("mockintquestion");
                    questionholder.style.display = "block";
                    questionholder.value = questions[ii];
                    questionholder.setAttribute("class","question-holder");
                });
            });
        }
    }).catch(function (err) {
        // There was an error
        console.warn('Something went wrong.', err);
    });
}

function displayMockInterviewQuestion(question) {
    document.getElementById("mockintquestion").value = question;

}
function displayMockInterviewAnswer(answer) {
    document.getElementById("mockintanswer").value = answer;
}


function showMockInterviewOverlay() {
    document.getElementById("mockintoverlay").style.display = "block";
}

function closeMockInterviewOverlay() {
    document.getElementById("mockintoverlay").style.display = "none";
}

async function getUserProfile() {
    let username = "Jason";
    fetch('http://localhost:4567/user/'+username).then(function (response) {
        // The API call was successful!
        return response.json();
    }).then(function (data) {
        // This is the JSON from our response
        console.log(data);
        let prof_user = document.getElementById('prof_user').innerHTML = "Username: " + data.username;
        let prof_fname = document.getElementById('prof_fname').innerHTML = "First Name: " + data.firstName;
        let prof_lname = document.getElementById('prof_lname').innerHTML = "Last Name: " + data.lastName;
        let prof_email = document.getElementById('prof_email').innerHTML = "Email: " + data.email;
        document.getElementById("myprofilecontainer").style.display="block";
    }).catch(function (err) {
        // There was an error
        console.warn('Something went wrong.', err);
    });
}

function closeUserProfile() {
    document.getElementById("myprofilecontainer").style.display="none";
}