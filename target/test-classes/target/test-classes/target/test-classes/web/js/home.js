
function openPostForm() {
    document.getElementById("myForm").style.display = "block";
}

function closeForm() {
    document.getElementById("myForm").style.display = "none";
}

async function newPost() {
    // this successfully creates a new post but does not return it correctly
    var form = document.getElementById("newpost");
    var body = form.elements.body.value;

    fetch('http://localhost:4567/post',{
        method: 'POST',
        mode: 'cors',
        headers: {'Content-Type': 'application/json', 'Access-Control-Allow-Origin':'*', 'Access-Control-Allow-Methods':'GET, POST'},
        body: JSON.stringify({
            username: 'Theo',
            postType: 'Question',
            content: body,
            tags: 'tags',
            likes: 0})
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

function displayMyPosts() {
    var posts = getMyPosts("Jason");
}

async function getMyPosts(username) {
    fetch('http://localhost:4567/posts/'+username).then(function (response) {
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

function displayAnswers() {
    getAnswers("1");
}

async function getAnswers(askpostID) {
    fetch('http://localhost:4567/answers/'+askpostID ).then(function (response) {
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

