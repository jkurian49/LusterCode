function openLoginForm() {
    document.getElementById("lform").style.display = "block";
    document.getElementById("sform").style.display = "none";
}
function closeLoginForm() {
    document.getElementById("lform").style.display = "none";
}

function openSignupForm() {
    document.getElementById("sform").style.display = "block";
    document.getElementById("lform").style.display = "none";
}

function closeSignupForm() {
    document.getElementById("sform").style.display = "none";
}

function openConfirmForm() {
    document.getElementById("cform").style.display = "block";
}

function openFailForm() {
    document.getElementById("fform").style.display = "block";
}

async function newSignup() {
    var form = document.getElementById("signupform");

    var first = form.elements.first.value;
    var last = form.elements.last.value;
    var user = form.elements.user.value;
    var pass = form.elements.pass.value;
    var email = form.elements.email.value;

    fetch('http://localhost:4567/user',{
        method: 'POST',
        mode: 'cors',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            username: user,
            password: pass,
            firstName: first,
            lastName: last,
            email: email})
    }).then(function (response) {
        // The API call was successful!
        return response.json();
    }).then(function (data) {
        // This is the JSON from our response
        openConfirmForm();
        closeSignupForm();
        console.log(data);
    }).catch(function (err) {
        // There was an error
        console.warn('Something went wrong.', err);
    });
}


async function login() {
    var form = document.getElementById("loginform");
    var username = form.elements.username.value;
    var password = form.elements.password.value;

    fetch('http://localhost:4567/user/'+username+'/'+password).then(function (response) {
        // The API call was successful!
        return response.json();
    }).then(function (data) {
        // This is the JSON from our response
        console.log(data);
        if (data.includes("success")){
            window.location.href = "OLDhome.html";
        } else {
            openFailForm();
        }
    }).catch(function (err) {
        // There was an error
        console.warn('Something went wrong.', err);
    });
}