/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.aerogear.security.picketbox.auth;

import org.jboss.aerogear.security.auth.CredentialFactory;
import org.jboss.aerogear.security.model.AeroGearUser;
import org.picketbox.core.authentication.credential.OTPCredential;
import org.picketbox.core.authentication.credential.UsernamePasswordCredential;
import org.picketlink.credential.LoginCredentials;

import javax.inject.Inject;

public class CredentialFactoryImpl implements CredentialFactory {

    @Inject
    private LoginCredentials loginCredentials;

    public void setOtpCredential(AeroGearUser user) {
        loginCredentials.setCredential(new OTPCredential(user.getId(), user.getPassword(), user.getOtp()));
    }

    @Override
    public void setCredential(AeroGearUser user) {
        loginCredentials.setCredential(new UsernamePasswordCredential(user.getId(), user.getPassword()));
    }
}