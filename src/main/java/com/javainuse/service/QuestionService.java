package com.javainuse.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.javainuse.model.QuesionObject;

@Service
public class QuestionService {

	private final KieContainer kieContainer;
	
	@Autowired
	public QuestionService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}
	
	public QuesionObject getProductDiscount(QuesionObject product) {
		KieSession kieSession = kieContainer.newKieSession("rulesSessionNew");
		kieSession.insert(product);
		kieSession.fireAllRules();
		kieSession.dispose();
		return product;
	}
}
