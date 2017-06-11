package com.wyq.hf.service.debitcredit;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.wyq.hf.po.Debitcreditinfo;
import com.yinbo.service.EntityManager;

public interface DebitcreditManager  extends EntityManager<Debitcreditinfo,Integer> {

	public List<Debitcreditinfo> findDebitcreditList(HttpServletRequest request);
}
