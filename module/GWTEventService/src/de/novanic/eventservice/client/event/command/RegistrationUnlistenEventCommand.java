/*
 * GWTEventService
 * Copyright (c) 2009, GWTEventService Committers
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package de.novanic.eventservice.client.event.command;

import de.novanic.eventservice.client.event.RemoteEventConnector;
import de.novanic.eventservice.client.event.listener.unlisten.UnlistenEvent;
import de.novanic.eventservice.client.logger.ClientLogger;
import de.novanic.eventservice.client.logger.ClientLoggerFactory;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Registers an {@link de.novanic.eventservice.client.event.listener.unlisten.UnlistenEvent} which will be transfered to
 * other clients/users when that user/client gets a timeout or deregisters a {@link de.novanic.eventservice.client.event.listener.RemoteEventListener}.
 *
 * @author sstrohschein
 *         <br>Date: 07.07.2009
 *         <br>Time: 23:22:43
 */
public class RegistrationUnlistenEventCommand extends ServerCallCommand<Void>
{
    private static final ClientLogger LOG = ClientLoggerFactory.getClientLogger();

    private UnlistenEvent myUnlistenEvent;

    /**
     * Creates an ServerCallCommand to execute and handle server calls.
     *
     * @param aRemoteEventConnector {@link de.novanic.eventservice.client.event.RemoteEventConnector}
     * @param anUnlistenEvent {@link de.novanic.eventservice.client.event.listener.unlisten.UnlistenEvent} will be transfered to other clients/users when
     * that user/client gets a timeout or deregisters a {@link de.novanic.eventservice.client.event.listener.RemoteEventListener}.
     * @param aVoidAsyncCallback callback of the command
     */
    public RegistrationUnlistenEventCommand(RemoteEventConnector aRemoteEventConnector, UnlistenEvent anUnlistenEvent, AsyncCallback<Void> aVoidAsyncCallback) {
        super(aRemoteEventConnector, aVoidAsyncCallback);
        myUnlistenEvent = anUnlistenEvent;
    }

    /**
     * Registers an {@link de.novanic.eventservice.client.event.listener.unlisten.UnlistenEvent}.
     */
    public void execute() {
        LOG.log("Unlisten-Listener registered.");
        getRemoteEventConnector().registerUnlistenEvent(myUnlistenEvent, getCommandCallback());
    }
}