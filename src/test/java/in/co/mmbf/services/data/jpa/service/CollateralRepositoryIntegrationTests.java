/*
 * Copyright 2012-2014 the original author or authors.
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

package in.co.mmbf.services.data.jpa.service;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import in.co.mmbf.services.data.RestApplication;
import in.co.mmbf.services.data.jpa.domain.MemberType;

@RunWith(SpringRunner.class)
@ActiveProfiles("mock")
@SpringBootTest(classes=RestApplication.class, webEnvironment=WebEnvironment.RANDOM_PORT)
public class CollateralRepositoryIntegrationTests {

	@Autowired
	MemberTypeRepository repository;

	@Test
	public void findsFirstPageOfCities() {

		List<MemberType> memberTypes = repository.findAll();
		assertThat(memberTypes.size(), is(equalTo(5)));
	}
}
