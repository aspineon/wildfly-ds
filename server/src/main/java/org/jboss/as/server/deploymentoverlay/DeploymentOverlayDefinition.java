package org.jboss.as.server.deploymentoverlay;

import org.jboss.as.controller.AttributeDefinition;
import org.jboss.as.controller.SimpleResourceDefinition;
import org.jboss.as.controller.descriptions.ModelDescriptionConstants;
import org.jboss.as.controller.registry.ManagementResourceRegistration;

/**
 * @author Stuart Douglas
 */
public class DeploymentOverlayDefinition extends SimpleResourceDefinition {

    public static final DeploymentOverlayDefinition INSTANCE = new DeploymentOverlayDefinition();

    private static final AttributeDefinition[] ATTRIBUTES = { };

    public static AttributeDefinition[] attributes() {
        return ATTRIBUTES.clone();
    }

    private DeploymentOverlayDefinition() {
        super(DeploymentOverlayModel.DEPLOYMENT_OVERRIDE_PATH,
                DeploymentOverlayModel.getResourceDescriptionResolver(ModelDescriptionConstants.DEPLOYMENT_OVERLAY),
                DeploymentOverlayAdd.INSTANCE,
                DeploymentOverlayRemove.INSTANCE);
    }

    @Override
    public void registerAttributes(final ManagementResourceRegistration resourceRegistration) {
        for (AttributeDefinition attr : ATTRIBUTES) {
            resourceRegistration.registerReadOnlyAttribute(attr, null);
        }
    }
}