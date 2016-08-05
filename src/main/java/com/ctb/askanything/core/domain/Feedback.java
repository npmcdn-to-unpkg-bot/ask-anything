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

package com.ctb.askanything.core.domain;

import java.util.UUID;

import lombok.Data;

/**
 * Feedback.
 *
 * @author Johnny Lim
 */
@Data
public class Feedback {

	private String id;
	private Long timestampInMillis;
	private String answerId;
	private String body;
	private String requestIpAddress;

	public Feedback(String answerId, String body, String requestIpAddress) {
		this.id = UUID.randomUUID().toString();
		this.timestampInMillis = System.currentTimeMillis();
		this.answerId = answerId;
		this.body = body;
		this.requestIpAddress = requestIpAddress;
	}

}
