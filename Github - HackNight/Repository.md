# Repository & Open Source
## `git clone`
This command clones a repository into a new directory. Creates remote-tracking branches for each branch in the cloned repository.

Most of the times this is the first step to setup your local environment.

## `git fork`
This command allows you to copy a repository to your space without afecting the original project.

In github, this functionality can be found at the Web interface on the top right.

Sometimes you get to create awesome features that are not in the original project. For those cases you can make a Pull Request across repositories.

## `git remote`
Git allows you to track different repositories. This command is very handy when you work with `forked` repositories.
  - `git remote -v` lists all tracked repositories
  - `git remote add <name_remote> <remote_URI>` adds a remote track
  -  `git remote remove <name_remote>` to remove a remote track
