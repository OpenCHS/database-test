package org.openchs.model.community

import org.openchs.model.Group

case class Family(override val members: Set[Patient]) extends Group