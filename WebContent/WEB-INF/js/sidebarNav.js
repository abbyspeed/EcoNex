const bodyElement = document.querySelector("body"),
      sideBar = bodyElement.querySelector(".sideBar");
      
const toggle = document.getElementById(".toggle");

toggle.addEventListener("click", () => {
    sideBar.classList.toggle("close");
});