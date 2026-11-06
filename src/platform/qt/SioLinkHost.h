/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QString>

namespace QGBA {

/**
 * The SIO link driver surface the cloud bridge needs (分开控制模式). CoreController
 * implements it over sio_link.c; tests can back it with a bare sio_link so the
 * cloud SIO path stays end-to-end testable without a running core.
 */
struct SioLinkHost {
	virtual ~SioLinkHost() = default;

	/** Native listens on the local port (1P). */
	virtual bool sioHost(quint16 port) = 0;

	/** Native connects out to a local listener (2P). */
	virtual bool sioJoin(const QString& host, quint16 port) = 0;

	virtual void sioClose() = 0;
};

}
