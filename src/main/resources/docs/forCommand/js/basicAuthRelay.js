
            /**
             * XHR
             */
            var btn = document.getElementById('post');

            btn.addEventListener('click', function () {

                var url = document.getElementById('url');
                var userName = document.getElementById('userName');
                var passwd = document.getElementById('passwd');

                var authorizationBasic = window.btoa(userName + ':' + passwd);

                var request = new XMLHttpRequest();
                request.open('POST', url);
                request.setRequestHeader('Authorization', 'Basic ' + authorizationBasic);
                request.setRequestHeader('Accept', 'application/json');
                request.setRequestHeader('Content-Type', 'application/json');
//                request.setRequestHeader('Content-Length', '*');
                request.withCredentials = true;
                request.send(JSON.stringify('data : empty'));

            });


            /** 
             *  Titanium
             */
//            xhr = Ti.Network.createHTTPClient();
//            xhr.onload = function () {
//                // snip
//            };
//            xhr.onerror = function () {
//                // snip
//            };
//            var url = document.getElementById('url');
//            var userName = document.getElementById('userName');
//            var passwd = document.getElementById('passwd');
//
//            xhr.open('POST', url);
//
//            // NOTE: 'Basic ' の後に半角スペースが必要...
//            var authstr = 'Basic ' + Ti.Utils.base64encode(userName + ':' + passwd);
//            xhr.setRequestHeader('Authorization', authstr);
//            xhr.send();

            /** 
             *  GAS
             */
//            var btn = document.getElementById('post');
//
//            btn.addEventListener('click', function () {
//                var url = document.getElementById('url');
//                var userName = document.getElementById('userName');
//                var passwd = document.getElementById('passwd');
//
//                var auth_data = Utilities.base64Encode(userName + ":" + passwd);
//                /* POSTするBODYを設定 */
//                var data = {
//                    "A": "AAA",
//                    "B": "BBB"
//                };
//                /* POSTするためのOPTIONを設定 */
//                var options = {
//                    "method": "post",
//                    "contentType": "application/json",
//                    "payload": JSON.stringify(data),
//                    "headers": {"Authorization": "Basic " + auth_data},
//                    "muteHttpExceptions": true
//                };
//                var response = UrlFetchApp.fetch(url, options);
//                Logger.log(response.getContentText());
//            });

