//支出录入
$(document).ready(function(){
			$.formValidator.initConfig({formid:"payoutenterForm",onerror:function(msg){},onsuccess:function(){return true;}});
			$("#payoutType").formValidator({empty:false,onshow:" ",onfocus:"请选择支出方式",oncorrect:"校验通过",defaultvalue:""}).inputValidator({min:1,onerror: "支出方式必须选择"});
			$("#payoutTarget").formValidator({empty:false,onshow:" ",onfocus:"请选择支出对象",oncorrect:"校验通过",defaultvalue:""}).inputValidator({min:1,onerror: "支出对象必须选择"});
			$("#payoutUser").formValidator({empty:false,onshow:" ",onfocus:"请选择支出者",oncorrect:"校验通过",defaultvalue:""}).inputValidator({min:1,onerror: "支出者必须选择"});
			$("#payoutMoney").formValidator({empty:false,onshow:" ",onfocus:"必须符合金额格式,如20.05",oncorrect:"校验通过"}).regexValidator({regexp:"^[0-9]+(.[0-9]{1,2})?$",onerror:"支出金额不能为空且须符合金额格式"}).inputValidator({min:1,max:18,onerror:"支出金额长度不正确"});
			$("#payoutPdescription").formValidator({empty:false,onshow:" ",onfocus:"请输入1-80个字符",oncorrect:"校验通过"}).inputValidator({min:1,onerror:"支出说明不能为空"}).inputValidator({min:1,max:80,onerror:"支出说明长度不正确"});
			$("#payoutremark").formValidator({empty:true,onshow:" ",onfocus:"请输入0-250个字符",oncorrect:"校验通过"}).inputValidator({min:0,max:250,onerror:"备注信息长度不正确"});
		});
	