//����֤
//��Ҫ��֤����required����
//���Ե���֤���� required="string"|"int"|"number"|"file"|"email" Ĭ��string
function validate(form) {
	for (i = 0; i < form.elements.length; i++) {
		if (form.elements[i].required != "undefined") {
			var data = form.elements[i];
			var method = form.elements[i].required;
			if (method == null && method == "") {
				method = "string";
			}
			var reg = /string/i; //��֤��Ϊ��
			if (reg.test(method) && data.value.replace(/(^\s*)|(\s*$)/g, "") == "") {
				alert("\u5e26*\u53f7\u7684\u4e3a\u5fc5\u586b\uff01");
				data.value = "";
				data.focus();
				return false;
			}
			reg = /int/i;   //��֤������
			var intReg = /^[0-9]+$/;
			if (reg.test(method) && !(intReg.test(data.value))) {
				alert("\u975e\u6cd5\u6574\u6570\uff01");
				data.value = "";
				data.focus();
				return false;
			}
			reg = /number/i; //��֤ʱ����
			var numberReg = /^([0-9]+\.?[0-9]+|[0-9]+)$/;
			if (reg.test(method) && !numberReg.test(data.value)) {
				alert("\u975e\u6cd5\u7684\u6570\u5b57\uff01");
				data.value = "";
				data.focus();
				return false;
			}
			reg = /file/i; //��֤�ַ�
			var fileReg = /^[a-zA-Z]:\\.+/;
			if (reg.test(method) && !fileReg.test(data.value)) {
				alert("\u975e\u6cd5\u7684\u6587\u4ef6\u8def\u5f84\uff01");
				data.value = "";
				data.focus();
				return false;
			}
			reg = /email/i; //��֤����
			var emailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
			if (reg.test(method) && !emailReg.test(data.value)) {
				alert("\u90ae\u7bb1\u5730\u5740\u9519\u8bef!xx@xx.xxx");
				data.value = "";
				data.focus();
				return false;
			}
		}
	}
	return true;
}

