
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
    console.log(content.message);
}


function displayMyPostsTable() {
    if (document.getElementById("mypoststable").style.visibility === "none")
        document.getElementById("mypoststable").style.visibility="visible";
    else
        document.getElementById("mypoststable").style.visibility="none";
}