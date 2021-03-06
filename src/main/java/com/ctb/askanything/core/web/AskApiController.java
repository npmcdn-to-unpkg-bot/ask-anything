/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ctb.askanything.core.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ctb.askanything.api.domain.Answer;
import com.ctb.askanything.api.domain.Question;
import com.ctb.askanything.core.service.AnswerService;

/**
 * Controller for ask APIs.
 *
 * @author Johnny Lim
 */
@RestController
@RequestMapping(path = "/api/v1/ask")
public class AskApiController {

	@Autowired
	private AnswerService answerService;

	@GetMapping
	public Answer ask(@RequestParam String question, HttpServletRequest request) {
		String requestIpAddress = request.getRemoteAddr();
		Question questionContainer = new Question(question, requestIpAddress);
		return this.answerService.ask(questionContainer);
	}

}
