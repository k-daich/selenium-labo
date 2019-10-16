// ラジオボタンがいずれかがチェック状態ならtrueになるフラグ
var checkedAnyRadio;

window.onload = function () {
    var form = document.getElementById('xpathButtons');

    // xpathButtonsにclickリスナーを定義
    form.addEventListener('click', function (event) {
        console.log('[click Event] : start');
        var clickedId = event.target.getAttribute('id');

        // 各ラジオボタンタグを取得
        var xpath1 = document.getElementById('input_id_1');
        var xpath2 = document.getElementById('input_id_2');
        var xpath3 = document.getElementById('input_id_3');
        var xpath4 = document.getElementById('input_id_4');

        // チェック状態を取得
        var checked1 = xpath1.getAttribute('id') === clickedId;
        var checked2 = xpath2.getAttribute('id') === clickedId;
        var checked3 = xpath3.getAttribute('id') === clickedId;
        var checked4 = xpath4.getAttribute('id') === clickedId;

        // チェック状態に応じてラジオボタンの色を変更
        setRadioStyle(checked1 ,xpath1);
        setRadioStyle(checked2 ,xpath2);
        setRadioStyle(checked3 ,xpath3);
        setRadioStyle(checked4 ,xpath4);

        // いずれかがチェック状態であればボタンの色を変更
        setBtnStyle();

        console.log(event.target);
    }, false);

    function setRadioStyle(checked, element) {
        console.log('[checked radio]' + checked);
        checkedAnyRadio = checkedAnyRadio || checked;

        if (checked) {
            element.nextElementSibling.style.backgroundColor = "#d81b60";
            element.nextElementSibling.style.color = "#FFFFFF";
        } else {
            element.nextElementSibling.style.backgroundColor = "#FFFFFF";
            element.nextElementSibling.style.color = "#b6b6b6";
        }
    }
    function setBtnStyle() {
    	var btn = document.getElementById('decide_btn');
        if (checkedAnyRadio) {
            btn.style.backgroundColor = "#336";
            btn.style.color = "#FFF";
        }
    }
}

function decide () {
	if (checkedAnyRadio) {
		window.close();
	}
}
