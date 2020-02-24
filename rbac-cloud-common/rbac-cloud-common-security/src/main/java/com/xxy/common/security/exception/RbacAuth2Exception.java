/*
 *  Copyright (c) 2019-2020, 冷冷 (wangiegie@gmail.com).
 *  <p>
 *  Licensed under the GNU Lesser General Public License 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  <p>
 * https://www.gnu.org/licenses/lgpl.html
 *  <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xxy.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.xxy.common.security.component.RbacAuth2ExceptionSerializer;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author xxy

 * 自定义OAuth2Exception
 */
@JsonSerialize(using = RbacAuth2ExceptionSerializer.class)
public class RbacAuth2Exception extends OAuth2Exception {
	@Getter
	private String errorCode;

	public RbacAuth2Exception(String msg) {
		super(msg);
	}

	public RbacAuth2Exception(String msg, String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}
}
