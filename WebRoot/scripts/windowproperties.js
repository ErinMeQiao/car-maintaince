function resize_dialog(l,t,w,h) {
			window.dialogLeft = l+"px";
			window.dialogTop = t+"px";
			window.dialogWidth = w+"px";
			window.dialogHeight = h+"px";
		}
function openDialage(url,flushUrl)
			{
				window.showModalDialog(url);
				setTimeout(function(){
					   window.location.href=flushUrl;
				},0);
			}