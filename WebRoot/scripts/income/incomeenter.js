//支出录入
$(document).ready(function(){
			$.formValidator.initConfig({formid:"consumeenterForm",onerror:function(msg){},onsuccess:function(){return true;}});
			$("#incomeTarget").formValidator({empty:false,onshow:" ",onfocus:"请选择收入对象",oncorrect:"校验通过",defaultvalue:""}).inputValidator({min:1,onerror: "收入对象必须选择"});
			$("#incomeUser").formValidator({empty:false,onshow:" ",onfocus:"请选择收入者",oncorrect:"校验通过",defaultvalue:""}).inputValidator({min:1,onerror: "收入者必须选择"});
			$("#incomeMoney").formValidator({empty:false,onshow:" ",onfocus:"必须符合金额格式,如20.05",oncorrect:"校验通过"}).regexValidator({regexp:"^[0-9]+(.[0-9]{1,2})?$",onerror:"收入金额不能为空且须符合金额格式"}).inputValidator({min:1,max:18,onerror:"收入金额长度不正确"});
			$("#incomeCdescription").formValidator({empty:false,onshow:" ",onfocus:"请输入1-80个字符",oncorrect:"校验通过"}).inputValidator({min:1,onerror:"收入说明不能为空"}).inputValidator({min:1,max:80,onerror:"收入说明长度不正确"});
			$("#incomeremark").formValidator({empty:true,onshow:" ",onfocus:"请输入0-250个字符",oncorrect:"校验通过"}).inputValidator({min:0,max:250,onerror:"备注信息长度不正确"});
		});
	