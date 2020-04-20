
function openPostForm() {
    document.getElementById("myForm").style.display = "block";
}

function closeForm() {
    document.getElementById("myForm").style.display = "none";
}

async function newPost() {
    var form = document.getElementById("newpost");
    var body = form.elements.body.value;

    const response = await fetch('http://localhost:4567/post', {
        method: 'POST',
        mode: 'cors',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            username: 'Theo',
            postType: 'Question',
            content: body,
            tags: 'tags',
            likes: 0})
    });
    const content = await response.json();
    console.log(content);
}


async function displayAnswers() {
    fetch('http://localhost:4567/answers/1').then(function (response) {
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

