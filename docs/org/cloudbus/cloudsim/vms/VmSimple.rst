.. java:import:: org.cloudbus.cloudsim.core UniquelyIdentificable

.. java:import:: org.cloudbus.cloudsim.datacenters Datacenter

.. java:import:: org.cloudbus.cloudsim.util Log

.. java:import:: org.cloudbus.cloudsim.brokers DatacenterBroker

.. java:import:: org.cloudbus.cloudsim.cloudlets Cloudlet

.. java:import:: org.cloudbus.cloudsim.core Simulation

.. java:import:: org.cloudbus.cloudsim.hosts Host

.. java:import:: org.cloudsimplus.autoscaling VmScaling

.. java:import:: org.cloudsimplus.listeners VmHostEventInfo

.. java:import:: org.cloudsimplus.listeners VmDatacenterEventInfo

.. java:import:: org.cloudsimplus.listeners EventListener

.. java:import:: org.cloudbus.cloudsim.schedulers.cloudlet CloudletScheduler

VmSimple
========

.. java:package:: PackageDeclaration
   :noindex:

.. java:type:: public class VmSimple implements Vm

   Implements the basic features of a Virtual Machine (VM) that runs inside a \ :java:ref:`Host`\  that may be shared among other VMs. It processes \ :java:ref:`cloudlets <Cloudlet>`\ . This processing happens according to a policy, defined by the \ :java:ref:`CloudletScheduler`\ . Each VM has a owner (user), which can submit cloudlets to the VM to execute them.

   :author: Rodrigo N. Calheiros, Anton Beloglazov

Constructors
------------
VmSimple
^^^^^^^^

.. java:constructor:: public VmSimple(int id, double mipsCapacity, int numberOfPes)
   :outertype: VmSimple

   Creates a Vm with 1024 MEGABYTE of RAM, 1000 Megabits/s of Bandwidth and 1024 MEGABYTE of Storage Size. To change these values, use the respective setters. While the Vm \ :java:ref:`is being instantiated <isCreated()>`\ , such values can be changed freely.

   :param id: unique ID of the VM
   :param mipsCapacity: the mips capacity of each Vm \ :java:ref:`Pe`\
   :param numberOfPes: amount of \ :java:ref:`Pe`\  (CPU cores)

VmSimple
^^^^^^^^

.. java:constructor:: @Deprecated public VmSimple(int id, DatacenterBroker broker, double mipsCapacity, int numberOfPes, long ramCapacity, long bwCapacity, long size, String vmm, CloudletScheduler cloudletScheduler)
   :outertype: VmSimple

   Creates a Vm with the given parameters.

   :param id: unique ID of the VM
   :param broker: ID of the VM's owner, that is represented by the id of the \ :java:ref:`DatacenterBroker`\
   :param mipsCapacity: the mips capacity of each Vm \ :java:ref:`Pe`\
   :param numberOfPes: amount of \ :java:ref:`Pe`\  (CPU cores)
   :param ramCapacity: amount of ram in Megabytes
   :param bwCapacity: amount of bandwidth to be allocated to the VM (in Megabits/s)
   :param size: size the VM image in Megabytes (the amount of storage it will use, at least initially).
   :param vmm: Virtual Machine Monitor that manages the VM lifecycle
   :param cloudletScheduler: scheduler that defines the execution policy for Cloudlets inside this Vm

Methods
-------
addOnHostAllocationListener
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Vm addOnHostAllocationListener(EventListener<VmHostEventInfo> listener)
   :outertype: VmSimple

addOnHostDeallocationListener
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Vm addOnHostDeallocationListener(EventListener<VmHostEventInfo> listener)
   :outertype: VmSimple

addOnUpdateVmProcessingListener
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Vm addOnUpdateVmProcessingListener(EventListener<VmHostEventInfo> listener)
   :outertype: VmSimple

addOnVmCreationFailureListener
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Vm addOnVmCreationFailureListener(EventListener<VmDatacenterEventInfo> listener)
   :outertype: VmSimple

addStateHistoryEntry
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void addStateHistoryEntry(VmStateHistoryEntry entry)
   :outertype: VmSimple

compareTo
^^^^^^^^^

.. java:method:: @Override public int compareTo(Vm o)
   :outertype: VmSimple

   Compare this Vm with another one based on \ :java:ref:`getTotalMipsCapacity()`\ .

   :param o: the Vm to compare to
   :return: {@inheritDoc}

equals
^^^^^^

.. java:method:: @Override public boolean equals(Object o)
   :outertype: VmSimple

getBroker
^^^^^^^^^

.. java:method:: @Override public DatacenterBroker getBroker()
   :outertype: VmSimple

getBw
^^^^^

.. java:method:: @Override public long getBw()
   :outertype: VmSimple

getCloudletScheduler
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public CloudletScheduler getCloudletScheduler()
   :outertype: VmSimple

getCurrentAllocatedBw
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public long getCurrentAllocatedBw()
   :outertype: VmSimple

getCurrentAllocatedRam
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public long getCurrentAllocatedRam()
   :outertype: VmSimple

getCurrentAllocatedSize
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public long getCurrentAllocatedSize()
   :outertype: VmSimple

   Gets the current allocated storage size.

   :return: the current allocated size

   **See also:** :java:ref:`.getSize()`

getCurrentRequestedBw
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public long getCurrentRequestedBw()
   :outertype: VmSimple

getCurrentRequestedMaxMips
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public double getCurrentRequestedMaxMips()
   :outertype: VmSimple

getCurrentRequestedMips
^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Double> getCurrentRequestedMips()
   :outertype: VmSimple

getCurrentRequestedRam
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public long getCurrentRequestedRam()
   :outertype: VmSimple

getCurrentRequestedTotalMips
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public double getCurrentRequestedTotalMips()
   :outertype: VmSimple

getHorizontalScaling
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public VmScaling getHorizontalScaling()
   :outertype: VmSimple

getHost
^^^^^^^

.. java:method:: @Override public Host getHost()
   :outertype: VmSimple

getId
^^^^^

.. java:method:: @Override public int getId()
   :outertype: VmSimple

getMips
^^^^^^^

.. java:method:: @Override public double getMips()
   :outertype: VmSimple

getNumberOfPes
^^^^^^^^^^^^^^

.. java:method:: @Override public int getNumberOfPes()
   :outertype: VmSimple

getRam
^^^^^^

.. java:method:: @Override public long getRam()
   :outertype: VmSimple

getResource
^^^^^^^^^^^

.. java:method:: @Override public <R extends ResourceManageable> ResourceManageable getResource(Class<R> resourceClass)
   :outertype: VmSimple

   :param resourceClass: the class of the resource to be got

getSimulation
^^^^^^^^^^^^^

.. java:method:: @Override public Simulation getSimulation()
   :outertype: VmSimple

getSize
^^^^^^^

.. java:method:: @Override public long getSize()
   :outertype: VmSimple

getStateHistory
^^^^^^^^^^^^^^^

.. java:method:: @Override public List<VmStateHistoryEntry> getStateHistory()
   :outertype: VmSimple

   Gets the history of MIPS capacity allocated to the VM.

   :return: the state history

getSubmissionDelay
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public double getSubmissionDelay()
   :outertype: VmSimple

getTotalMipsCapacity
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public double getTotalMipsCapacity()
   :outertype: VmSimple

getTotalUtilizationOfCpu
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public double getTotalUtilizationOfCpu()
   :outertype: VmSimple

getTotalUtilizationOfCpu
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public double getTotalUtilizationOfCpu(double time)
   :outertype: VmSimple

getTotalUtilizationOfCpuMips
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public double getTotalUtilizationOfCpuMips(double time)
   :outertype: VmSimple

   Gets the total CPU utilization of all cloudlets running on this VM at the given time (in MIPS).

   :param time: the time
   :return: total cpu utilization in MIPS

   **See also:** :java:ref:`.getTotalUtilizationOfCpu(double)`

getUid
^^^^^^

.. java:method:: @Override public String getUid()
   :outertype: VmSimple

getVmm
^^^^^^

.. java:method:: @Override public String getVmm()
   :outertype: VmSimple

hashCode
^^^^^^^^

.. java:method:: @Override public int hashCode()
   :outertype: VmSimple

isCreated
^^^^^^^^^

.. java:method:: @Override public boolean isCreated()
   :outertype: VmSimple

isFailed
^^^^^^^^

.. java:method:: @Override public boolean isFailed()
   :outertype: VmSimple

isInMigration
^^^^^^^^^^^^^

.. java:method:: @Override public boolean isInMigration()
   :outertype: VmSimple

notifyOnHostAllocationListeners
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void notifyOnHostAllocationListeners()
   :outertype: VmSimple

notifyOnHostDeallocationListeners
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void notifyOnHostDeallocationListeners(Host deallocatedHost)
   :outertype: VmSimple

notifyOnUpdateVmProcessing
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void notifyOnUpdateVmProcessing()
   :outertype: VmSimple

   Notifies all registered listeners when the processing of the Vm is updated in its \ :java:ref:`Host`\ .

notifyOnVmCreationFailureListeners
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void notifyOnVmCreationFailureListeners(Datacenter failedDatacenter)
   :outertype: VmSimple

removeOnHostAllocationListener
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean removeOnHostAllocationListener(EventListener<VmHostEventInfo> listener)
   :outertype: VmSimple

removeOnHostDeallocationListener
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean removeOnHostDeallocationListener(EventListener<VmHostEventInfo> listener)
   :outertype: VmSimple

removeOnUpdateVmProcessingListener
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean removeOnUpdateVmProcessingListener(EventListener<VmHostEventInfo> listener)
   :outertype: VmSimple

removeOnVmCreationFailureListener
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean removeOnVmCreationFailureListener(EventListener<VmDatacenterEventInfo> listener)
   :outertype: VmSimple

setBroker
^^^^^^^^^

.. java:method:: @Override public final Vm setBroker(DatacenterBroker broker)
   :outertype: VmSimple

setBw
^^^^^

.. java:method:: @Override public final Vm setBw(long bwCapacity)
   :outertype: VmSimple

setCloudletScheduler
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public final Vm setCloudletScheduler(CloudletScheduler cloudletScheduler)
   :outertype: VmSimple

setCreated
^^^^^^^^^^

.. java:method:: @Override public final void setCreated(boolean created)
   :outertype: VmSimple

setFailed
^^^^^^^^^

.. java:method:: @Override public void setFailed(boolean failed)
   :outertype: VmSimple

setHorizontalScaling
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public Vm setHorizontalScaling(VmScaling horizontalScaling) throws IllegalArgumentException
   :outertype: VmSimple

setHost
^^^^^^^

.. java:method:: @Override public void setHost(Host host)
   :outertype: VmSimple

setId
^^^^^

.. java:method:: protected final void setId(int id)
   :outertype: VmSimple

   Sets the VM id.

   :param id: the new VM id, that has to be unique for the current \ :java:ref:`broker <getBroker()>`\

setInMigration
^^^^^^^^^^^^^^

.. java:method:: @Override public final void setInMigration(boolean inMigration)
   :outertype: VmSimple

setMips
^^^^^^^

.. java:method:: protected final void setMips(double mips)
   :outertype: VmSimple

   Sets the individual MIPS capacity of any VM's PE, considering that all PEs have the same capacity.

   :param mips: the new mips for every VM's PE

setNumberOfPes
^^^^^^^^^^^^^^

.. java:method:: protected final void setNumberOfPes(int numberOfPes)
   :outertype: VmSimple

   Sets the number of PEs required by the VM.

   :param numberOfPes: the new number of PEs

setRam
^^^^^^

.. java:method:: @Override public final Vm setRam(long ramCapacity)
   :outertype: VmSimple

setSize
^^^^^^^

.. java:method:: @Override public final Vm setSize(long size)
   :outertype: VmSimple

setSubmissionDelay
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public final void setSubmissionDelay(double submissionDelay)
   :outertype: VmSimple

setVmm
^^^^^^

.. java:method:: protected final void setVmm(String vmm)
   :outertype: VmSimple

   Sets the Virtual Machine Monitor (VMM) that manages the VM.

   :param vmm: the new VMM

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: VmSimple

updateVmProcessing
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public double updateVmProcessing(double currentTime, List<Double> mipsShare)
   :outertype: VmSimple
