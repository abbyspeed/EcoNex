window.addEventListener("DOMContentLoaded", (event) => {
    const body = document.querySelector("body"),
          sideBar = body.querySelector(".sideBar");

    const toggle = document.querySelector(".toggle");
    toggle.addEventListener("click", () => {
        sideBar.classList.toggle("close");
    });
});
