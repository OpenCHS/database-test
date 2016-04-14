package org.openchs.model.provider

import org.openchs.model.Group

case class ProviderGroup(override val members: Set[Provider]) extends Group