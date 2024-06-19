document.addEventListener("DOMContentLoaded", function () {
    $.get("pancakes/cookie/getAll", function (data) {
        data.forEach(function (cookie) {
            var commentHtml = '<div class="item">' +
                '<span>' + cookie.name + '</span>' +
                '<p></p>' +
                '<div class = wrapper>' +
                '<img id="cookie" src="/images/cookie.jpg" alt="cookie"/>' +
                '</div>' +
                '<span>Описание: ' + cookie.description + '</span>' +
                '<span>Цена:' + cookie.price + '</span>'
            $('.items').append(commentHtml);
        });
    })
});