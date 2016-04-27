# jenkins

# NOTE:
   Please remove mount: variable from jenkins/roles/jenkins/vars/CentOS/7.yml file if you are not using external storage [NFS MOUNT] for jenkins HOME.

   You can have all the configrations on NFS MOUNT /jenkins/home and then simple symlink from jenkins default home.
   ln -s /jenkins/home /var/lib/jenkins

   In case you losse the VM, comfigrations and data still be safe on external mount point. we can simply run this ansible job which would bring jenkins to old state.

# Install jenkins 2.

  Please update version in var file in order to install jenkins 2. Its is set to 1.
