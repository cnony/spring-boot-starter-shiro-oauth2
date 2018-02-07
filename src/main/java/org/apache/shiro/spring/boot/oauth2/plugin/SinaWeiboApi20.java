/*
 * Copyright (c) 2010-2020, wandalong (hnxyhcwdl1003@163.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.apache.shiro.spring.boot.oauth2.plugin;

import org.scribe.builder.api.DefaultApi20;
import org.scribe.model.OAuthConfig;
import org.scribe.model.Verb;
import org.scribe.utils.OAuthEncoder;

/**
 * 
 * @className	： SinaWeiboApi20
 * @description	： TODO(描述这个类的作用)
 * @author 		： <a href="https://github.com/vindell">vindell</a>
 * @date		： 2018年2月7日 下午6:09:04
 * @version 	V1.0
 */
public class SinaWeiboApi20 extends DefaultApi20 {

	@Override
	public Verb getAccessTokenVerb() {
		return Verb.POST;
	}

	@Override
	public String getAccessTokenEndpoint() {
		return OAuthConstants.SINA_ACCESS_TOKEN_URL;
	}

	@Override
	public String getAuthorizationUrl(OAuthConfig config) {
		// Append scope if present
		if (config.hasScope()) {
			return String.format(OAuthConstants.SINA_SCOPED_AUTHORIZE_URL, config.getApiKey(),
					OAuthEncoder.encode(config.getCallback()), OAuthEncoder.encode(config.getScope()));
		} else {
			return String.format(OAuthConstants.SINA_AUTHORIZE_URL, config.getApiKey(),
					OAuthEncoder.encode(config.getCallback()));
		}
	}

}