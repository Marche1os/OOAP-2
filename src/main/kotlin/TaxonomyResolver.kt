class SmartDevice(
    val activationState: ActivationState
) {
    fun changeState(newState: ActivationState) {}

    fun signalDeviceActivationState() { activationState.signalState() }
}

interface ActivationState {
    fun signalState()
}

class Active: ActivationState {
    override fun signalState() {
        // Устройство активно
    }
}

class NotActive: ActivationState {
    override fun signalState() {
        // Устройство неактивно
    }
}

class PlannedActivation: ActivationState {
    override fun signalState() {
        // запланировано включение
    }
}