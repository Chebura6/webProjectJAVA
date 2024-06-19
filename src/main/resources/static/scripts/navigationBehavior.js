
let currentPage = document.location.pathname.split("/").pop();
let menuItems = document.querySelectorAll('a')
menuItems.forEach(function(item) {
    let href = item.getAttribute('href')
    if (href === currentPage) {
        item.classList.add('active');
    }
});
