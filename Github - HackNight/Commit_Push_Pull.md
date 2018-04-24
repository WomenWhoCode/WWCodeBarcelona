# Commit, push, pull

## Pull

Gets the latest content from [origin](Github.md#Origin) the [branch](Branches.md) you're currently on and [merges](Merge.md) them into your [local](Github.md#Local) branch.

`git pull`

This will get latest from origin and merge it with the current parameters of your branch. Get more information about [Git Pull](https://git-scm.com/docs/git-pull) in the Docs.

### Fetch

You can also use `git fetch` to get the newest changes, but this command won't merge the changes into your branch, you would have to do that separately.

If you want to do a tricky merge or run a different set of parameters doing a fetch + merge separately is recommended.

### Trick

If you want to do a Fetch + Rebase instead of Fetch + Merge you can still use pull, just add a parameter change in the end:

`git pull --rebase`

## Commit

Record your local changes to the repository. It stores this changes with an index and a log message the user provides.

  - `git commit -m "Log explaining the changes"` Automatically commits the staged or added files with the message between "".
  - `git commit -a` Adds the current tracked files and starts the commit on terminal so you can enter your log
  - `git commit Filename.extension` Adds one file and commits it

If you want to learn how to write good commit messages you should read [this post](https://chris.beams.io/posts/git-commit/). Also in the [documentation for Git-Commit](https://git-scm.com/docs/git-commit) you will find all possible commands for commit or you can run `git commit --help` on terminal to get them.

Before you Commit some changes you need to decide what changes you want to commit. (This applies for new files, removed files and just edited files)

### Status

`git status` will show you every file that has been modified and is being tracked by the repository. There are some files that are not tracked sometimes, status will also show untracked files unless they're ignored by `.gitignore`. Read more about [untracked files here](https://git-scm.com/book/en/v2/Git-Basics-Recording-Changes-to-the-Repository).

### Add files

Some of the most used add files commands for commits. It is recommended to a lot of do small commits (with small changes) over doing a really big commit with every change.

  - `git add -all `  Adds every change on a tracked file in the current repository to your commit
  - `git add -p` || `git add -patch` Shows you patches of changed content and gives you an opportunity to decide which hunks to stage or not
  - `git add Filename.extension` you can also just add all the changes to a particular file or folder

You can see all the different options of `git add` in [the documentation](https://git-scm.com/docs/git-add) or by running `git add -h` || `git add -help` on your terminal.

### Remove files

If you added/staged a file that you do not want it to be part of your commit you can run `git rm FileName.extension` and it will be removed from the tree

### Reset

### Amends

## Push
