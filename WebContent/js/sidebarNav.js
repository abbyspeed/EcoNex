window.addEventListener("DOMContentLoaded", (event) => {
    const body = document.querySelector("body"),
          sideBar = body.querySelector(".sideBar"),
          folded = body.querySelector(".folded");

    const toggle = document.querySelector(".toggle");
    toggle.addEventListener("click", () => {
        // sideBar.classList.toggle("close");
    	const display = sideBar.computedStyleMap().get("display");
    });
});
