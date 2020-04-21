
function openPostForm() {
    document.getElementById("myForm").style.display = "block";
}

function closeForm() {
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
    table.setAttribute("class","table");
    table.style.width = '80%';
    table.style.borderBottom = '5px solid black';
    table.style.marginLeft = "auto";
    table.style.marginRight = "auto";
    table.style.marginTop = "15%";
    table.setAttribute('cellspacing', '0');
    table.setAttribute('cellpadding', '5');
    table.setAttribute('height', '500px');


    // retrieve column header ('Name', 'Email', and 'Mobile')

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
    /*
        for (var i=0;i<data.length;i++) {
            var username = data[i].username;
            var content  = data[i].content;
        } */
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

function displayAnswers() {
    getAnswers("1");
}

async function getPost(askpostID) {
    fetch('http://localhost:4567/post/'+askpostID ).then(function (response) {
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

async function getAnswer(answerID) {
    fetch('http://localhost:4567/answer/'+answerID ).then(function (response) {
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

async function getMockInterviews(mockintid) {
    fetch('http://localhost:4567/mockinterview/'+mockintid).then(function (response) {
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
