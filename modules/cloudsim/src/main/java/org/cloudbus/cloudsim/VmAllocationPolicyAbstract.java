/*
 * Title:        CloudSim Toolkit
 * Description:  CloudSim (Cloud Simulation) Toolkit for Modeling and Simulation of Clouds
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2009-2012, The University of Melbourne, Australia
 */
package org.cloudbus.cloudsim;

import java.util.List;
import java.util.Map;
import org.cloudbus.cloudsim.core.CloudSim;

/**
 * VmAllocationPolicyAbstract is an abstract class that represents the policy
 used by a {@link Datacenter Datacenters} to choose a {@link Host} to allocate
 * a given {@link Vm} into. It supports two-stage commit of reservation of
 * hosts: first, we reserve the host and, once committed by the user, it is
 * effectively allocated to he/she.<p/>
 *
 * Each {@link Datacenter} has to have its own instance of a class that extends
 the VmAllocationPolicyAbstract.
 *
 * @author Rodrigo N. Calheiros
 * @author Anton Beloglazov
 * @since CloudSim Toolkit 1.0
 */
public abstract class VmAllocationPolicyAbstract implements VmAllocationPolicy {

    /**
     * @see #getVmTable()
     */
    private Map<String, Host> vmTable;

    /**
     * @see #getHostList()
     */
    private List<? extends Host> hostList;

    /**
     * Creates a new VmAllocationPolicy object.
     *
     * @param list of Hosts available in a {@link Datacenter}, that will be used
     * by the Allocation Policy to place VMs.
     * @pre $none
     * @post $none
     */
    public VmAllocationPolicyAbstract(List<? extends Host> list) {
        setHostList(list);
    }

    /**
     * Sets the list of Hosts available in a {@link Datacenter}, that will be
     * used by the Allocation Policy to place VMs.
     *
     * @param hostList the new host list
     */
    protected final void setHostList(List<? extends Host> hostList) {
        this.hostList = hostList;
    }

    /**
     * Gets the list of Hosts available in a {@link Datacenter}, that will be
     * used by the Allocation Policy to place VMs.
     *
     * @param <T> The generic type
     * @return the host list
     */
    @Override
    public <T extends Host> List<T> getHostList() {
        return (List<T>) hostList;
    }

    /**
     * Gets the map between a VM and its allocated host. The map key is a VM UID
     * and the value is the allocated host for that VM.
     *
     * @return the VM map
     */
    protected Map<String, Host> getVmTable() {
        return vmTable;
    }

    /**
     * Sets the vm table.
     *
     * @param vmTable the vm table
     */
    protected final void setVmTable(Map<String, Host> vmTable) {
        this.vmTable = vmTable;
    }

    /**
     * Register the allocation of a given Host to a Vm. It maps the placement of
     * the Vm into the given Host.
     *
     * @param vm the placed Vm
     * @param host the Host where the Vm has just been placed
     */
    protected void mapVmToPm(Vm vm, Host host) {
        // if vm were succesfully created in the host
        getVmTable().put(vm.getUid(), host);
        vm.getOnHostAllocationListener().update(CloudSim.clock(), vm, host);
    }

    /**
     * Unregister the allocation of a Host to a given Vm, unmapping the Vm to
     * the Host where it was. The method has to be called when a Vm is
     * moved/removed from a Host.
     *
     * @param vm the moved/removed Vm
     * @return the Host where the Vm was removed/moved from
     */
    protected Host unmapVmFromPm(Vm vm) {
        final Host host = getVmTable().remove(vm.getUid());
        vm.getOnHostDeallocationListener().update(CloudSim.clock(), vm, host);
        return host;
    }
}
