(function($) {
	$.oaconfirm = function() {
		$(a).each(function() {
			if($(this).text() == "ɾ��") {
				$(this).unbind("click");
				$(this).bind("click",function() {
					return window.confirm("��ȷ��Ҫɾ����?");
				})
			}
		});
	}
})($);
