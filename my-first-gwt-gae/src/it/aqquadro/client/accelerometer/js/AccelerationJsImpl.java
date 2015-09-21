/*
 * Copyright 2010 Daniel Kurka
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
package it.aqquadro.client.accelerometer.js;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;

import it.aqquadro.client.accelerometer.Acceleration;

public final class AccelerationJsImpl extends JavaScriptObject implements Acceleration {

	protected AccelerationJsImpl() {

	}

	@Override
	public native double getGamma()/*-{
		return this.gamma;
	}-*/;

	@Override
	public native double getBeta()/*-{
		return this.beta;
	}-*/;

	@Override
	public native double getAlpha()/*-{
		return this.alpha;
	}-*/;

	private native double getTimeStamp0()/*-{
		return new Date().getTime();
	}-*/;
	
	public native double getOrient()/*-{
		return $wnd.orientation || 0;
	}-*/;

	@Override
	public Date getTimeStamp() {
		return new Date(Math.round(getTimeStamp0()));
	}
}
