package com.lk.oa.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lk.oa.model.Duty;
import com.lk.oa.service.DutyService;

public class DutyTest {

	@Test
	public void testSave() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		DutyService dutyService = (DutyService) ctx.getBean("dutyService");
		Duty duty1 = new Duty();
		duty1.setName("����");
		duty1.setPid(0L);
		duty1.setParent(true);
		dutyService.saveEntry(duty1);
		
		Duty duty2 = new Duty();
		duty2.setName("IT��");
		duty2.setPid(duty1.getId());
		dutyService.saveEntry(duty2);
		
		Duty duty3 = new Duty();
		duty3.setName("����������");
		duty3.setPid(duty1.getId());
		dutyService.saveEntry(duty3);
		
		Duty duty4 = new Duty();
		duty4.setName("�ܾ���");
		duty4.setPid(0L);
		duty4.setParent(true);
		dutyService.saveEntry(duty4);
		
		Duty duty5 = new Duty();
		duty5.setName("���³��칫��");
		duty5.setPid(duty4.getId());
		duty5.setParent(true);
		dutyService.saveEntry(duty5);
		
		Duty duty6 = new Duty();
		duty6.setName("����");
		duty6.setPid(duty4.getId());
		duty6.setParent(true);
		dutyService.saveEntry(duty6);
		
	}

}
