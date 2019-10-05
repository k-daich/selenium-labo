console.log('[clickListener.js] start');
var body = document.getElementsByTagName('body');

body[0].addEventListener('click', function (event) {
    event.preventDefault();

    console.log(event.target);
}, false);

