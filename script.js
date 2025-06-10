function myFunction(x) {
  x.classList.toggle("change");
}
function myFunction(menuIcon) {
  menuIcon.classList.toggle("change"); // Toggle the menu icon animation
  const menuItems = document.getElementById("menuItems");
  if (menuItems.style.display === "block") {
      menuItems.style.display = "none"; // Hide menu
  } else {
      menuItems.style.display = "block"; // Show menu
  }
}

/*2nd Login page opening*/
var scroll = new SmoothScroll('a[href*="#services"]', {
speed: 1000,
speedAsDuration: true
});

function loginpage(){
  window.open("index_Login.html");
}
function openscreen(){
  window.open("signup.html");
}
/*flip card*/

function flip() {

  document.querySelector('.flip-card-inner').style.transform = "rotateY(180deg)";

}

function flipAgain() {

  document.querySelector('.flip-card-inner').style.transform = "rotateY(0deg)";

}


let eye = document.getElementById("eye-login");
let password = document.getElementById("password-login");

eye.onclick = function () {
  if (password.type == "password") {
      password.type = "text";
      eye.className = "fa fa-eye";
      eye.style.color = "cyan";
      // password.style.border =" 1px solid cyan";


  } else {
      password.type = "password"
      eye.className = "fa fa-eye-slash";
      eye.style.color = "white";
      // password.style.border =" 1px solid white";


  }
}


let eye2 = document.getElementById("eye-signup");
let password2 = document.getElementById("password-signup");

eye2.onclick = function () {
  if (password2.type == "password") {
      password2.type = "text";
      eye2.className = "fa fa-eye";
      eye2.style.color = "cyan";
      // password2.style.border =" 1px solid cyan";



  } else {
      password2.type = "password"
      eye2.className = "fa fa-eye-slash";
      eye2.style.color = "white";
      // password2.style.border =" 1px solid white";


  }
}
//main bank page navigation bar coding starts from here
function toggleNav() {
  var sidebar = document.getElementById("mySidebar");
  var menu = document.querySelector(".menu");

  // Open or close the sidebar
  if (sidebar.style.width === "250px") {
      sidebar.style.width = "0";
      menu.classList.remove("opened");
  } else {
      sidebar.style.width = "250px";
      menu.classList.add("opened");
  }
}

//logout pAGE
function logout() {
  fetch("LogoutServlet", { method: "GET" }) // Call LogoutServlet
  .then(() => {
      window.location.href = "index_Login.html"; // Redirect to login page
  })
  .catch(error => console.error("Error logging out:", error));
}






