
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
            username: 'Theo',
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

function displayMyPosts(data) {
    var noOfPosts = data.length;
    // CREATE DYNAMIC TABLE.
    var table = document.createElement("table");
    document.getElementById("mypoststable").style.display = "inline";
    table.setAttribute("class","table");
    table.style.borderBottom = '5px solid black';
    table.style.marginLeft = "auto";
    table.style.marginRight = "auto";
    table.style.marginTop = "10%";
    table.style.width = "80%";
    table.setAttribute('cellspacing', '0');
    table.setAttribute('cellpadding', '5');
    table.setAttribute('height', '500px');


    // retrieve column header

    var col = []; // define an empty array
    for (var i = 0; i < noOfPosts; i++) {
        for (var key in data[i]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }

    // CREATE TABLE HEAD .
    var tHead = document.createElement("thead");


    // CREATE ROW FOR TABLE HEAD .
    var hRow = document.createElement("tr");

    // ADD COLUMN HEADER TO ROW OF TABLE HEAD.
    for (var i = 0; i < col.length; i++) {
        var th = document.createElement("th");
        th.innerHTML = col[i];
        hRow.appendChild(th);
    }
    tHead.appendChild(hRow);
    table.appendChild(tHead);

    // CREATE TABLE BODY .
    var tBody = document.createElement("tbody");

    // ADD COLUMN HEADER TO ROW OF TABLE HEAD.
    for (var i = 0; i < noOfPosts; i++) {

        var bRow = document.createElement("tr"); // CREATE ROW FOR EACH RECORD .


        for (var j = 0; j < col.length; j++) {
            var td = document.createElement("td");
            td.innerHTML = data[i][col[j]];
            bRow.appendChild(td);
        }
        tBody.appendChild(bRow)

    }
    table.appendChild(tBody);


    // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
    var divContainer = document.getElementById("mypoststable");
    divContainer.innerHTML = "";
    divContainer.appendChild(table);
}

function closeMyPosts() {
    document.getElementById("mypoststable").style.display = "none";
}

async function getMyPosts() {
    var username = "Jason";
    fetch('http://localhost:4567/posts/'+username).then(function (response) {
        // The API call was successful!
        return response.json();
    }).then(function (data) {
        // This is the JSON from our response
        console.log(data);
        displayMyPosts(data);
    }).catch(function (err) {
        // There was an error
        console.warn('Something went wrong.', err);
    });
}

async function getPost(askPostID) {
    let post = null;
    fetch('http://localhost:4567/post/'+askPostID ).then(function (response) {
        // The API call was successful!
        return response.json();
    }).then(function (data) {

        return data;
    })
        // This is the JSON from our response
    .catch(function (err) {
        // There was an error
        console.warn('Something went wrong.', err);
    });
}

async function getAnswer(answerID) {
    fetch('http://localhost:4567/answer/'+answerID ).then(function (response) {
        // The API call was successful!
        return response.json();
    }).then(function (data) {
        // This is the JSON from our response
        return data;
    }).catch(function (err) {
        // There was an error
        console.warn('Something went wrong.', err);
    });
}

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
function Answer(answer) {
    this.answer = answer;
}
// function to take mock interview
async function showMockInterview(mockintid) {
    closeMockInterviewNav();
    let questions = [];
    let answers = [];
    // remove this hardcoded value
    for(let jj = 0; jj < 5;jj++){
        questions[jj] = new Post();
        answers[jj] = new Answer();
    }
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
                questions[ii].content = post.content;
                fetch('http://localhost:4567/answer/'+answerID ).then(function (response) {
                    // The API call was successful!
                    return response.json();
                }).then(function (answer) {
                    answers[ii].content = answer.content;
                });
            });
        }

    }).catch(function (err) {
        // There was an error
        console.warn('Something went wrong.', err);
    });
}


function showMockInterviewOverlay() {
    document.getElementById("mockintoverlay").style.display = "block";
}

function closeMockInterviewOverlay() {
    document.getElementById("mockintoverlay").style.display = "none";
}
