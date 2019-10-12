window.onload = function () {
    var form = document.getElementById('xpathButtons');
    form.addEventListener('click', function (event) {
        console.log('[click Event] : start');
        var clickedId = event.target.getAttribute('id');
        var xpath1 = document.getElementById('input_id_1');
        var xpath2 = document.getElementById('input_id_2');
        var xpath3 = document.getElementById('input_id_3');
        var xpath4 = document.getElementById('input_id_4');
        var checked1 = xpath1.getAttribute('id') == clickedId;
        var checked2 = xpath2.getAttribute('id') == clickedId;
        var checked3 = xpath3.getAttribute('id') == clickedId;
        var checked4 = xpath4.getAttribute('id') == clickedId;
        setStyle(checked1 ,xpath1);
        setStyle(checked2 ,xpath2);
        setStyle(checked3 ,xpath3);
        setStyle(xpath4.getAttribute('id') == clickedId ,xpath4);

        console.log(event.target);
    }, false);

    function setStyle(checked, element) {
    	console.log('[checked]' + checked);
        if (checked) {
            element.nextElementSibling.style.backgroundColor = "#d81b60";
            element.nextElementSibling.style.color = "#FFFFFF";
        } else {
            element.nextElementSibling.style.backgroundColor = "#FFFFFF";
            element.nextElementSibling.style.color = "#b6b6b6";
        }
    }
}
