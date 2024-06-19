document.addEventListener("DOMContentLoaded", function () {
    $.get("pancakes/bakery/getAll", function (data) {
        console.log(data);

        data.forEach(function (bakery) {
            var commentHtml = '<div class="item">' +
                '<span>' + bakery.name + '</span>' +
                '<p></p>' +
                '<div class = wrapper>' +
                '<img id="red-velvet" src="/images/red-velvet.svg" alt="red-violet"/>' +
                '</div>' +
                '<span>Описание: ' + bakery.description + '</span>' +
                '<span>Цена:' + bakery.price + '</span>'
            $('.items').append(commentHtml);
        });
    })
});