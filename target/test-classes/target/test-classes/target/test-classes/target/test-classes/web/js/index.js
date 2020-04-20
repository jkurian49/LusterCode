function openLoginForm() {
    document.getElementById("loginform").style.display = "block";
    document.getElementById("signupform").style.display = "none";
    alert("ALERT");
}

function closeLoginForm() {
    document.getElementById("loginform").style.display = "none";
}

function openSignupForm() {
    document.getElementById("signupform").style.display = "block";
    document.getElementById("loginform").style.display = "none";
}

function closeSignupForm() {
    document.getElementById("signupform").style.display = "none";
}