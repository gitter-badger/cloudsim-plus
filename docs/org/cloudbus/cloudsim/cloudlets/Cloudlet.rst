.. java:import:: org.cloudbus.cloudsim.core Delayable

.. java:import:: org.cloudbus.cloudsim.core UniquelyIdentificable

.. java:import:: org.cloudbus.cloudsim.datacenters Datacenter

.. java:import:: org.cloudbus.cloudsim.vms Vm

.. java:import:: org.cloudbus.cloudsim.brokers DatacenterBroker

.. java:import:: org.cloudbus.cloudsim.schedulers.cloudlet CloudletScheduler

.. java:import:: org.cloudbus.cloudsim.utilizationmodels UtilizationModel

.. java:import:: java.util Collections

.. java:import:: java.util List

.. java:import:: org.cloudbus.cloudsim.core Simulation

.. java:import:: org.cloudsimplus.listeners CloudletVmEventInfo

.. java:import:: org.cloudsimplus.listeners EventListener

Cloudlet
========

.. java:package:: org.cloudbus.cloudsim.cloudlets
   :noindex:

.. java:type:: public interface Cloudlet extends UniquelyIdentificable, Delayable, Comparable<Cloudlet>

   An interface to be implemented by each class that provides basic cloudlet features. The interface implements the Null Object Design Pattern in order to start avoiding \ :java:ref:`NullPointerException`\  when using the \ :java:ref:`Cloudlet.NULL`\  object instead of attributing \ ``null``\  to \ :java:ref:`Cloudlet`\  variables.

   :author: Rodrigo N. Calheiros, Anton Beloglazov, Manoel Campos da Silva Filho

Fields
------
NOT_ASSIGNED
^^^^^^^^^^^^

.. java:field::  int NOT_ASSIGNED
   :outertype: Cloudlet

   Value to indicate that the cloudlet was not assigned to a Datacenter yet.

NO_HISTORY_IS_RECORDED_FOR_CLOUDLET
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:field::  String NO_HISTORY_IS_RECORDED_FOR_CLOUDLET
   :outertype: Cloudlet

NULL
^^^^

.. java:field::  Cloudlet NULL
   :outertype: Cloudlet

   An attribute that implements the Null Object Design Pattern for \ :java:ref:`Cloudlet`\  objects.

Methods
-------
addOnCloudletFinishListener
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  Cloudlet addOnCloudletFinishListener(EventListener<CloudletVmEventInfo> listener)
   :outertype: Cloudlet

   Adds an OnCloudletFinishEventListener object that will be notified when a cloudlet finishes its execution at a given \ :java:ref:`Vm`\ .

   :param listener: the listener to add

addOnUpdateCloudletProcessingListener
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  Cloudlet addOnUpdateCloudletProcessingListener(EventListener<CloudletVmEventInfo> listener)
   :outertype: Cloudlet

   Adds a listener object that will be notified every time when the processing of the Cloudlet is updated in its \ :java:ref:`Vm`\ .

   :param listener: the listener to add

   **See also:** :java:ref:`.getFinishedLengthSoFar()`

addRequiredFile
^^^^^^^^^^^^^^^

.. java:method::  boolean addRequiredFile(String fileName)
   :outertype: Cloudlet

   Adds a file to the list or required files.

   :param fileName: the name of the required file
   :return: \ ``true``\  if the file was added (it didn't exist in the list of required files), \ ``false``\  otherwise (it did already exist)

addRequiredFiles
^^^^^^^^^^^^^^^^

.. java:method::  boolean addRequiredFiles(List<String> fileNames)
   :outertype: Cloudlet

   Adds a list of files to the required files list. Just the files that don't exist yet in the current required list will be added.

   :param fileNames: the list of files to be added
   :return: \ ``true``\  if at leat one file was added, false if no file was added (in the case that all given files already exist in the current required list)

assignToDatacenter
^^^^^^^^^^^^^^^^^^

.. java:method::  void assignToDatacenter(Datacenter datacenter)
   :outertype: Cloudlet

   Sets the parameters of the Datacenter where the Cloudlet is going to be executed. From the second time this method is called, every call makes the cloudlet to be migrated to the indicated Datacenter.

   \ **NOTE**\ : This method \ ``should``\  be called only by a \ :java:ref:`Datacenter`\  entity.

   :param datacenter: the Datacenter where the cloudlet will be executed

deleteRequiredFile
^^^^^^^^^^^^^^^^^^

.. java:method::  boolean deleteRequiredFile(String filename)
   :outertype: Cloudlet

   Deletes the given filename from the list.

   :param filename: the given filename to be deleted
   :return: \ ``true``\  if the file was found and removed, \ ``false``\  if not found

getAccumulatedBwCost
^^^^^^^^^^^^^^^^^^^^

.. java:method::  double getAccumulatedBwCost()
   :outertype: Cloudlet

   The total bandwidth (bw) cost for transferring the cloudlet by the network, according to the \ :java:ref:`getFileSize()`\ .

   :return: the accumulated bw cost

getActualCpuTime
^^^^^^^^^^^^^^^^

.. java:method::  double getActualCpuTime(Datacenter datacenter)
   :outertype: Cloudlet

   Gets the total execution time of this Cloudlet in a given Datacenter ID.

   :param datacenter: the Datacenter entity
   :return: the total execution time of this Cloudlet in the given Datacenter or 0 if the Cloudlet was not executed there

getActualCpuTime
^^^^^^^^^^^^^^^^

.. java:method::  double getActualCpuTime()
   :outertype: Cloudlet

   Returns the total execution time of the Cloudlet in seconds.

   :return: time in which the Cloudlet was running or \ :java:ref:`NOT_ASSIGNED`\  if it hasn't finished yet

getArrivalTime
^^^^^^^^^^^^^^

.. java:method::  double getArrivalTime(Datacenter datacenter)
   :outertype: Cloudlet

   Gets the arrival time of this Cloudlet in the given Datacenter.

   :param datacenter: the Datacenter entity
   :return: the arrival time or \ :java:ref:`NOT_ASSIGNED`\  if the cloudlet has never been assigned to a Datacenter

getBroker
^^^^^^^^^

.. java:method::  DatacenterBroker getBroker()
   :outertype: Cloudlet

   Gets the \ :java:ref:`DatacenterBroker`\  that represents the owner of the Cloudlet.

getCostPerBw
^^^^^^^^^^^^

.. java:method::  double getCostPerBw()
   :outertype: Cloudlet

   Gets the cost of each byte of bandwidth (bw) consumed.

   :return: the cost per bw

getCostPerSec
^^^^^^^^^^^^^

.. java:method::  double getCostPerSec()
   :outertype: Cloudlet

   Gets the cost/sec of running the Cloudlet in the latest Datacenter.

   :return: the cost associated with running this Cloudlet or \ ``0.0``\  if was not assigned to any Datacenter yet

getCostPerSec
^^^^^^^^^^^^^

.. java:method::  double getCostPerSec(Datacenter datacenter)
   :outertype: Cloudlet

   Gets the cost running this Cloudlet in a given Datacenter.

   :param datacenter: the Datacenter entity
   :return: the cost associated with running this Cloudlet in the given Datacenter or 0 if the Cloudlet was not executed there not found

getExecStartTime
^^^^^^^^^^^^^^^^

.. java:method::  double getExecStartTime()
   :outertype: Cloudlet

   Gets the latest execution start time of this Cloudlet. With new functionalities, such as CANCEL, PAUSED and RESUMED, this attribute only stores the latest execution time. Previous execution time are ignored. This time represents the simulation second when the cloudlet started.

   :return: the latest execution start time

getFileSize
^^^^^^^^^^^

.. java:method::  long getFileSize()
   :outertype: Cloudlet

   Gets the input file size of this Cloudlet before execution (in bytes). This size has to be considered the program + input data sizes.

   :return: the input file size of this Cloudlet (in bytes)

getFinishTime
^^^^^^^^^^^^^

.. java:method::  double getFinishTime()
   :outertype: Cloudlet

   Gets the time when this Cloudlet has completed executing in the latest Datacenter. This time represents the simulation second when the cloudlet finished.

   :return: the finish or completion time of this Cloudlet; or \ :java:ref:`NOT_ASSIGNED`\  if not finished yet.

getFinishedLengthSoFar
^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  long getFinishedLengthSoFar()
   :outertype: Cloudlet

   Gets the length of this Cloudlet that has been executed so far from the latest Datacenter (in MI). This method is useful when trying to move this Cloudlet into different Datacenter or to cancel it.

   :return: the length of a partially executed Cloudlet, or the full Cloudlet length if it is completed

getFinishedLengthSoFar
^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  long getFinishedLengthSoFar(Datacenter datacenter)
   :outertype: Cloudlet

   Gets the length of this Cloudlet that has been executed so far (in MI), according to the \ :java:ref:`getLength()`\ . This method is useful when trying to move this Cloudlet into different Datacenters or to cancel it.

   :param datacenter: the Datacenter entity
   :return: the length of a partially executed Cloudlet; the full Cloudlet length if it is completed; or 0 if the Cloudlet has never been executed in the given Datacenter

getHistory
^^^^^^^^^^

.. java:method::  String getHistory()
   :outertype: Cloudlet

   Gets the transaction history of this Cloudlet. The layout of this history is in a readable table column with \ ``time``\  and \ ``description``\  as headers.

   :return: a String containing the history of this Cloudlet object.

getLastDatacenter
^^^^^^^^^^^^^^^^^

.. java:method::  Datacenter getLastDatacenter()
   :outertype: Cloudlet

   Gets the latest \ :java:ref:`Datacenter`\  where the Cloudlet was processed.

   :return: the Datacenter or  if the Cloudlet has not being processed yet.

getLastDatacenterArrivalTime
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  double getLastDatacenterArrivalTime()
   :outertype: Cloudlet

   Gets the arrival time of this Cloudlet from the latest Datacenter where it has executed.

   :return: the arrival time or \ :java:ref:`NOT_ASSIGNED`\  if the cloudlet has never been assigned to a Datacenter

getLength
^^^^^^^^^

.. java:method::  long getLength()
   :outertype: Cloudlet

   Gets the execution length of this Cloudlet (in Million Instructions (MI)) that will be executed in each defined PE.

   According to this length and the power of the VM processor (in Million Instruction Per Second - MIPS) where the cloudlet will be run, the cloudlet will take a given time to finish processing. For instance, for a cloudlet of 10000 MI running on a processor of 2000 MIPS, the cloudlet will spend 5 seconds using the processor in order to be completed (that may be uninterrupted or not, depending on the scheduling policy).

   :return: the length of this Cloudlet

   **See also:** :java:ref:`.getTotalLength()`, :java:ref:`.getNumberOfPes()`

getNetServiceLevel
^^^^^^^^^^^^^^^^^^

.. java:method::  int getNetServiceLevel()
   :outertype: Cloudlet

   Gets the Type of Service (ToS) of IPv4 for sending Cloudlet over the network. It is the ToS this cloudlet receives in the network (applicable to selected PacketScheduler class only).

   :return: the network service level

getNumberOfPes
^^^^^^^^^^^^^^

.. java:method::  int getNumberOfPes()
   :outertype: Cloudlet

   Gets the number of Processing Elements (PEs) from the VM, that is required to execute this cloudlet.

   :return: number of PEs

   **See also:** :java:ref:`.getTotalLength()`

getOutputSize
^^^^^^^^^^^^^

.. java:method::  long getOutputSize()
   :outertype: Cloudlet

   Gets the output file size of this Cloudlet after execution (in bytes). It is the data produced as result of cloudlet execution that needs to be transferred thought the network to simulate sending response data to the user.

   :return: the Cloudlet output file size (in bytes)

getPriority
^^^^^^^^^^^

.. java:method::  int getPriority()
   :outertype: Cloudlet

   Gets the priority of this Cloudlet for scheduling inside a Vm. Each \ :java:ref:`CloudletScheduler`\  implementation can define if it will use this attribute to impose execution priorities or not. How the priority is interpreted and what is the range of values it accepts depends on the \ :java:ref:`CloudletScheduler`\  that is being used by the Vm running the Cloudlet.

   :return: priority of this cloudlet

getRequiredFiles
^^^^^^^^^^^^^^^^

.. java:method::  List<String> getRequiredFiles()
   :outertype: Cloudlet

   Gets the list of required files to be used by the cloudlet (if any). The time to transfer these files by the network is considered when placing the cloudlet inside a given VM

   :return: the required files

getResponseTime
^^^^^^^^^^^^^^^

.. java:method::  double getResponseTime()
   :outertype: Cloudlet

getSimulation
^^^^^^^^^^^^^

.. java:method::  Simulation getSimulation()
   :outertype: Cloudlet

   Gets the CloudSim instance that represents the simulation the Entity is related to.

getStatus
^^^^^^^^^

.. java:method::  Status getStatus()
   :outertype: Cloudlet

   Gets the execution status of this Cloudlet.

   :return: the Cloudlet status

getTotalCost
^^^^^^^^^^^^

.. java:method::  double getTotalCost()
   :outertype: Cloudlet

   Gets the total cost of executing this Cloudlet. \ ``Total Cost = input data transfer + processing cost + output transfer cost``\  .

   :return: the total cost of executing the Cloudlet

getTotalLength
^^^^^^^^^^^^^^

.. java:method::  long getTotalLength()
   :outertype: Cloudlet

   Gets the total length (across all PEs) of this Cloudlet (in MI). It considers the \ :java:ref:`getLength()`\  of the cloudlet will be executed in each Pe defined by \ :java:ref:`getNumberOfPes()`\ .

   For example, setting the cloudletLenght as 10000 MI and \ :java:ref:`getNumberOfPes()`\  to 4, each Pe will execute 10000 MI. Thus, the entire Cloudlet has a total length of 40000 MI.

   :return: the total length of this Cloudlet (in MI)

   **See also:** :java:ref:`.getNumberOfPes()`, :java:ref:`.getLength()`

getUtilizationModelBw
^^^^^^^^^^^^^^^^^^^^^

.. java:method::  UtilizationModel getUtilizationModelBw()
   :outertype: Cloudlet

   Gets the utilization model that defines how the cloudlet will use the VM's bandwidth (bw).

   :return: the utilization model of bw

getUtilizationModelCpu
^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  UtilizationModel getUtilizationModelCpu()
   :outertype: Cloudlet

   Gets the utilization model that defines how the cloudlet will use the VM's CPU.

   :return: the utilization model of cpu

getUtilizationModelRam
^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  UtilizationModel getUtilizationModelRam()
   :outertype: Cloudlet

   Gets the utilization model that defines how the cloudlet will use the VM's RAM.

   :return: the utilization model of ram

getUtilizationOfBw
^^^^^^^^^^^^^^^^^^

.. java:method::  double getUtilizationOfBw(double time)
   :outertype: Cloudlet

   Gets the utilization of Bandwidth at a given time, that is defined in percentage or absolute values, depending of the \ :java:ref:`UtilizationModel.getUnit()`\  defined for the \ :java:ref:`getUtilizationModelBw()`\  ()}.

   :param time: the time to get the utilization
   :return: the utilization value

   **See also:** :java:ref:`.getUtilizationModelBw()()`

getUtilizationOfBw
^^^^^^^^^^^^^^^^^^

.. java:method::  double getUtilizationOfBw()
   :outertype: Cloudlet

   Gets the utilization of Bandwidth at the current simulation time, that is defined in percentage or absolute values, depending of the \ :java:ref:`UtilizationModel.getUnit()`\  set for the \ :java:ref:`BW utilizaton model <getUtilizationModelBw()>`\ .

   :return: the utilization value

   **See also:** :java:ref:`.getUtilizationModelCpu()`

getUtilizationOfCpu
^^^^^^^^^^^^^^^^^^^

.. java:method::  double getUtilizationOfCpu(double time)
   :outertype: Cloudlet

   Gets the utilization of CPU at a given time, that is defined in percentage or absolute values, depending of the \ :java:ref:`UtilizationModel.getUnit()`\  defined for the \ :java:ref:`getUtilizationModelCpu()`\ .

   :param time: the time to get the utilization
   :return: the utilization value

   **See also:** :java:ref:`.getUtilizationModelCpu()`

getUtilizationOfCpu
^^^^^^^^^^^^^^^^^^^

.. java:method::  double getUtilizationOfCpu()
   :outertype: Cloudlet

   Gets the utilization of CPU at the current simulation time, that is defined in percentage or absolute values, depending of the \ :java:ref:`UtilizationModel.getUnit()`\  set for the \ :java:ref:`CPU utilizaton model <getUtilizationModelCpu()>`\ .

   :return: the utilization value

   **See also:** :java:ref:`.getUtilizationModelCpu()`

getUtilizationOfRam
^^^^^^^^^^^^^^^^^^^

.. java:method::  double getUtilizationOfRam(double time)
   :outertype: Cloudlet

   Gets the utilization of RAM at a given time, that is defined in percentage or absolute values, depending of the \ :java:ref:`UtilizationModel.getUnit()`\  defined for the \ :java:ref:`getUtilizationModelRam()`\  ()}.

   :param time: the time to get the utilization
   :return: the utilization value

   **See also:** :java:ref:`.getUtilizationModelRam()()`

getUtilizationOfRam
^^^^^^^^^^^^^^^^^^^

.. java:method::  double getUtilizationOfRam()
   :outertype: Cloudlet

   Gets the utilization of RAM at the current simulation time, that is defined in percentage or absolute values, depending of the \ :java:ref:`UtilizationModel.getUnit()`\  set for the \ :java:ref:`RAM utilizaton model <getUtilizationModelRam()>`\ .

   :return: the utilization value

   **See also:** :java:ref:`.getUtilizationModelRam()`

getVm
^^^^^

.. java:method::  Vm getVm()
   :outertype: Cloudlet

   Gets the id of Vm that is planned to execute the cloudlet.

   :return: the VM, or \ :java:ref:`NOT_ASSIGNED`\  if the Cloudlet was not assigned to a VM yet

getWaitingTime
^^^^^^^^^^^^^^

.. java:method::  double getWaitingTime()
   :outertype: Cloudlet

   Gets the time the cloudlet had to wait before start executing on a resource.

   :return: the waiting time when the cloudlet waited to execute; or 0 if there wasn't any waiting time or the cloudlet hasn't started to execute.

getWallClockTime
^^^^^^^^^^^^^^^^

.. java:method::  double getWallClockTime(Datacenter datacenter)
   :outertype: Cloudlet

   Gets the time of this Cloudlet resides in a given Datacenter (from arrival time until departure time).

   :param datacenter: a Datacenter entity
   :return: the time of this Cloudlet resides in the Datacenter or 0 if the Cloudlet has never been executed there

getWallClockTimeInLastExecutedDatacenter
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  double getWallClockTimeInLastExecutedDatacenter()
   :outertype: Cloudlet

   Gets the time of this Cloudlet resides in the latest Datacenter (from arrival time until departure time).

   :return: the time of this Cloudlet resides in the latest Datacenter

isAssignedToDatacenter
^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  boolean isAssignedToDatacenter()
   :outertype: Cloudlet

   :return: true if the cloudlet has even been assigned to a Datacenter in order to run, false otherwise.

isBindToVm
^^^^^^^^^^

.. java:method::  boolean isBindToVm()
   :outertype: Cloudlet

   Indicates if the Cloudlet is bounded to a specific Vm, meaning that the \ :java:ref:`DatacenterBroker`\  doesn't have to select a VM for it. In this case, the Cloudlet was already bounded to a specific VM and must run on it.

   :return: true if the Cloudlet is bounded to a specific VM, false otherwise

isFinished
^^^^^^^^^^

.. java:method::  boolean isFinished()
   :outertype: Cloudlet

   Checks whether this Cloudlet has finished executing or not.

   :return: \ ``true``\  if this Cloudlet has finished execution, \ ``false``\  otherwise

notifyOnCloudletProcessingListeners
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  void notifyOnCloudletProcessingListeners(double time)
   :outertype: Cloudlet

   Notifies all registered listeners about the update on Cloudlet processing.

   \ **This method is used just internally and must not be called directly.**\

   :param time: the time the event happened

registerArrivalInDatacenter
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  double registerArrivalInDatacenter()
   :outertype: Cloudlet

   Register the arrival time of this Cloudlet into a Datacenter to the current simulation time and returns this time.

   :return: the arrived time set or \ :java:ref:`NOT_ASSIGNED`\  if the cloudlet is not assigned to a Datacenter

removeOnCloudletFinishListener
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  boolean removeOnCloudletFinishListener(EventListener<CloudletVmEventInfo> listener)
   :outertype: Cloudlet

   Removes a listener from the onCloudletFinishEventListener List

   :param listener: the listener to remove
   :return: true if the listener was found and removed, false otherwise

   **See also:** :java:ref:`.addOnCloudletFinishListener(EventListener)`

removeOnUpdateCloudletProcessingListener
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  boolean removeOnUpdateCloudletProcessingListener(EventListener<CloudletVmEventInfo> listener)
   :outertype: Cloudlet

   Removes a listener from the onUpdateCloudletProcessingListener List.

   :param listener: the listener to remove
   :return: true if the listener was found and removed, false otherwise

requiresFiles
^^^^^^^^^^^^^

.. java:method::  boolean requiresFiles()
   :outertype: Cloudlet

   Checks whether this cloudlet requires any files or not.

   :return: \ ``true``\  if required, \ ``false``\  otherwise

setBroker
^^^^^^^^^

.. java:method::  Cloudlet setBroker(DatacenterBroker broker)
   :outertype: Cloudlet

   Sets a \ :java:ref:`DatacenterBroker`\  that represents the owner of the Cloudlet.

   :param broker: the \ :java:ref:`DatacenterBroker`\  to set

setExecStartTime
^^^^^^^^^^^^^^^^

.. java:method::  void setExecStartTime(double clockTime)
   :outertype: Cloudlet

   Sets the \ :java:ref:`latest execution start time <getExecStartTime()>`\  of this Cloudlet.  \ **NOTE:**\  With new functionalities, such as being able to cancel / to pause / to resume this Cloudlet, the execution start time only holds the latest one. Meaning, all previous execution start time are ignored.

   :param clockTime: the latest execution start time

setFileSize
^^^^^^^^^^^

.. java:method::  Cloudlet setFileSize(long fileSize)
   :outertype: Cloudlet

   Sets the input file size of this Cloudlet before execution (in bytes). This size has to be considered the program + input data sizes.

   :param fileSize: the size to set (in bytes)
   :throws IllegalArgumentException: when the given size is lower or equal to zero

setFinishedLengthSoFar
^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  boolean setFinishedLengthSoFar(long length)
   :outertype: Cloudlet

   Sets the length of this Cloudlet that has been executed so far (in MI), according to the \ :java:ref:`getLength()`\ .

   :param length: executed length of this Cloudlet (in MI)
   :return: true if the length is valid and the cloudlet already has assigned to a Datacenter, false otherwise

   **See also:** :java:ref:`CloudletExecutionInfo`

setLength
^^^^^^^^^

.. java:method::  Cloudlet setLength(long length)
   :outertype: Cloudlet

   Sets the execution length of this Cloudlet (in Million Instructions (MI)) that will be executed in each defined PE.

   :param length: the length (in MI) of this Cloudlet to be executed in a Vm
   :throws IllegalArgumentException: when the given length is lower or equal to zero

   **See also:** :java:ref:`.getLength()`, :java:ref:`.getTotalLength()`

setNetServiceLevel
^^^^^^^^^^^^^^^^^^

.. java:method::  boolean setNetServiceLevel(int netServiceLevel)
   :outertype: Cloudlet

   Sets the Type of Service (ToS) for sending this cloudlet over a network.

   :param netServiceLevel: the new type of service (ToS) of this cloudlet
   :return: \ ``true``\  if the netServiceLevel is valid, false otherwise.

setNumberOfPes
^^^^^^^^^^^^^^

.. java:method::  Cloudlet setNumberOfPes(int numberOfPes)
   :outertype: Cloudlet

   Sets the number of PEs required to run this Cloudlet.  NOTE: The Cloudlet length is computed only for 1 PE for simplicity.  For example, consider a Cloudlet that has a length of 500 MI and requires 2 PEs. This means each PE will execute 500 MI of this Cloudlet.

   :param numberOfPes: number of PEs

setOutputSize
^^^^^^^^^^^^^

.. java:method::  Cloudlet setOutputSize(long outputSize)
   :outertype: Cloudlet

   Sets the output file size of this Cloudlet after execution (in bytes). It is the data produced as result of cloudlet execution that needs to be transferred thought the network to simulate sending response data to the user.

   :param outputSize: the output size to set (in bytes)
   :throws IllegalArgumentException: when the given size is lower or equal to zero

setPriority
^^^^^^^^^^^

.. java:method::  void setPriority(int priority)
   :outertype: Cloudlet

   Sets the \ :java:ref:`priority <getPriority()>`\  of this Cloudlet for scheduling inside a Vm. Each \ :java:ref:`CloudletScheduler`\  implementation can define if it will use this attribute to impose execution priorities or not. How the priority is interpreted and what is the range of values it accepts depends on the \ :java:ref:`CloudletScheduler`\  that is being used by the Vm running the Cloudlet.

   :param priority: priority of this Cloudlet

setStatus
^^^^^^^^^

.. java:method::  boolean setStatus(Status newStatus)
   :outertype: Cloudlet

   Sets the status of this Cloudlet.

   :param newStatus: the status of this Cloudlet
   :return: true if the cloudlet status was changed, i.e, if the newStatus is different from the current status; false otherwise

setUtilizationModel
^^^^^^^^^^^^^^^^^^^

.. java:method::  Cloudlet setUtilizationModel(UtilizationModel utilizationModel)
   :outertype: Cloudlet

   Sets the \ **same utilization model**\  for defining the usage of Bandwidth, CPU and RAM. To set different utilization models for each one of these resources, use the respective setters.

   :param utilizationModel: the new utilization model for BW, CPU and RAM

   **See also:** :java:ref:`.setUtilizationModelBw(UtilizationModel)`, :java:ref:`.setUtilizationModelCpu(UtilizationModel)`, :java:ref:`.setUtilizationModelRam(UtilizationModel)`

setUtilizationModelBw
^^^^^^^^^^^^^^^^^^^^^

.. java:method::  Cloudlet setUtilizationModelBw(UtilizationModel utilizationModelBw)
   :outertype: Cloudlet

   Sets the \ :java:ref:`utilization model of bw <getUtilizationModelBw()>`\ .

   :param utilizationModelBw: the new utilization model of bw

setUtilizationModelCpu
^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  Cloudlet setUtilizationModelCpu(UtilizationModel utilizationModelCpu)
   :outertype: Cloudlet

   Sets the \ :java:ref:`utilization model of cpu <getUtilizationModelCpu()>`\ .

   :param utilizationModelCpu: the new utilization model of cpu

setUtilizationModelRam
^^^^^^^^^^^^^^^^^^^^^^

.. java:method::  Cloudlet setUtilizationModelRam(UtilizationModel utilizationModelRam)
   :outertype: Cloudlet

   Sets the \ :java:ref:`utilization model of ram <getUtilizationModelRam()>`\ .

   :param utilizationModelRam: the new utilization model of ram

setVm
^^^^^

.. java:method::  Cloudlet setVm(Vm vm)
   :outertype: Cloudlet

   Sets the id of \ :java:ref:`Vm`\  that is planned to execute the cloudlet.

   :param vm: the id of vm to run the cloudlet

setWallClockTime
^^^^^^^^^^^^^^^^

.. java:method::  boolean setWallClockTime(double wallTime, double actualCpuTime)
   :outertype: Cloudlet

   Sets the wall clock time the cloudlet spent executing on the current Datacenter. The wall clock time is the total time the Cloudlet resides in a Datacenter (from arrival time until departure time, that may include waiting time). This value is set by the Datacenter before departure or sending back to the original Cloudlet's owner.

   :param wallTime: the time of this Cloudlet resides in a Datacenter (from arrival time until departure time).
   :param actualCpuTime: the total execution time of this Cloudlet in a Datacenter.
   :return: true if the submission time is valid and the cloudlet has already being assigned to a Datacenter for execution

