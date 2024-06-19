
function calculateLoadTime() {
    const pageEnd = performance.mark('pageEnd');
    return pageEnd.startTime;
}

function displayLoadStats() {
    console.log("timeee")
    var serverTime = parseFloat(document.querySelector("meta[name='server-time']").content);
    const loadStats = document.createElement('p');
    let timeToLoad = calculateLoadTime();
    loadStats.innerHTML = `Загрузка была завершена за ${timeToLoad} мс + ${serverTime} мс`;
    // var controller = Java.type("org.pancakes.MainController");
    // var time = controller.totalTime;
    // importClass(org.pancakes.MainController);
    document.querySelector('footer').appendChild(loadStats);
}

window.addEventListener('DOMContentLoaded', () => {
    displayLoadStats();
});


