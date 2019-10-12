// console.log('[clickListener.js] start');
var body = document.getElementsByTagName('body');

body[0].addEventListener('click', function (event) {
    console.log('[click Event] : start');
    event.preventDefault();

    console.log(event.target);
    var xpath = getXpath(event.target);
    document.getElementsByTagName('html')[0].setAttribute("rkrkXpath",xpath);
}, false);


function getXpath(element) {
	if (element && element.parentNode) {
		var xpath = getXpath(element.parentNode) + '/' + element.tagName;
		var s = [];

		for (var i = 0;i < element.parentNode.childNodes.length; i++) {
			var e = element.parentNode.childNodes[i];
			// console.log('[e.tagName] : ' + e.tagName + '\n[element.tagName] : ' +  element.tagName);

			if (e.tagName == element.tagName) {
				// console.log('[s.push(e)] \n [xpath] : ' + xpath + '\n[e.tagName] : ' + e.tagName);
				s.push(e);
			}
		}

		if(1 < s.length) {
			// console.log('[s.length] : ' + s.length + ' >>> at xpath : ' + xpath);
			for (var i = 0; i < s.length; i++) {
				if(s[i] === element) {
					xpath += '[' + (i+1) + ']';
					break;
				}
			}
		}

		return xpath.toLowerCase();
	}
	else {
		return '';
	}
}
