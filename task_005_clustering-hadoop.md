
# Task 5 - Setup Hadoop Cluster

Authored by Jaime during training.

## Describe your intent.

We need to find a way to allow hadoop to communicate with various
different instances of itself. The key point that might not be obvious
is that hadoop mirrors itself on different nodes. By design, each part
of a cluster is made redundant after replication.

With that in mind, our stategy to build a cluster is to configure the
cluster on one node first. Afterwards, we introduce more nodes.

More nodes will share the same configuration but will be different
because the environment is different. For example, every node is
configured identically, but its own hostname allows it to select the
configuration relevant to itself.

> Each node configures itself by its own context.

## Obliterate your Ubuntu 18.04 