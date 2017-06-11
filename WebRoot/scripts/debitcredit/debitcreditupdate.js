//借贷修改
$(document).ready(function(){
			$.formValidator.initConfig({formid:"debitcreditenterForm",onerror:function(msg){},onsuccess:function(){return true;}});
			$("#debitcreditUser").formValidator({empty:false,onshow:" ",onfocus:"请选择借贷者",oncorrect:"校验通过",defaultvalue:""}).inputValidator({min:1,onerror: "借贷者必须选择"});
			$("#debitcreditMoney").formValidator({empty:false,onshow:" ",onfocus:"必须符合金额格式,如20.05",oncorrect:"校验通过"}).regexValidator({regexp:"^[0-9]+(.[0-9]{1,2})?$",onerror:"借贷金额不能为空且须符合金额格式"}).inputValidator({min:1,max:18,onerror:"借贷金额长度不正确"});
			$("#debitcreditcdname").formValidator({empty:false,onshow:" ",onfocus:"请输入1-30个字符",oncorrect:"校验通过"}).inputValidator({min:1,onerror:"借贷对方名称不能为空"}).inputValidator({min:1,max:30,onerror:"借贷对方名称长度不正确"});
			$("#debitcreditCdescription").formValidator({empty:false,onshow:" ",onfocus:"请输入1-80个字符",oncorrect:"校验通过"}).inputValidator({min:1,onerror:"借贷说明不能为空"}).inputValidator({min:1,max:80,onerror:"借贷说明长度不正确"});
			$("#debitcreditInfocdflagTip").formValidator({empty:false,onshow:" ",onfocus:"请选择借贷标志",oncorrect:"校验通过",defaultvalue:""}).inputValidator({min:1,onerror: "借贷标志必须选择"});
			$("#repayflag").formValidator({empty:false,onshow:" ",onfocus:"请选择偿还标志",oncorrect:"校验通过",defaultvalue:""}).inputValidator({min:1,onerror: "偿还标志必须选择"});
			$("#debitcreditremark").formValidator({empty:true,onshow:" ",onfocus:"请输入0-250个字符",oncorrect:"校验通过"}).inputValidator({min:0,max:250,onerror:"备注信息长度不正确"});
		});
	