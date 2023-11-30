const tabs = document.querySelectorAll('.tab-item');
const content = document.querySelectorAll('.tab-content');

tabs.forEach((tab, index) => {
	tab.addEventListener('click', (e) => {
		tabs.forEach(tab => {tab.classList.remove('active')});
		tab.classList.add('active');
	})
	
	var line = document.querySelector('.menu-selected');
	line.style.width = e.target.offsetWidth + "px";
	line.style.left = e.target.offsetLeft + "px";
	
	content.forEach(content => {
		content.classList.remove('active');
	})
	content[index].classList.add('active');
})
