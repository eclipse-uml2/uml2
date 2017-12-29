#!/bin/bash -xv
#
#    Promote the PUBLISH__BUILD to an updates repository.
#
#    PUBLISH__BUILD_TYPE     Build type N/I/S, blank suppresses promotion
#    PUBLISH__BUILD          The base URL of the build to be published, e.g., https://hudson.eclipse.org/uml2/job/mdt-uml2-master/lastSuccessfulBuild/
#    PUBLISH__VERSION        Unqualified version, e.g., 5.4.0
#    PUBLISH__QUALIFIER      Version qualifier, e.g., v20171228-2349
#
updatesFolder="/home/data/httpd/download.eclipse.org/modeling/mdt/uml2/updates/"
group="modeling.mdt.uml2"
localZip="uml2.zip"
projectRepoName="Unified Modeling Language 2.x (UML2)"
manageComposite="/shared/common/apache-ant-latest/bin/ant -f /shared/modeling/tools/promotion/manage-composite.xml"

if [ -n "${PUBLISH__BUILD_TYPE}" ]
then

  if [ "${PUBLISH__BUILD_TYPE}" = "N" ]
  then
    repoFolder="${updatesFolder}${PUBLISH__VERSION:0:2}-N-builds"
    repoName="Nightly Build"
  elif [ "${PUBLISH__BUILD_TYPE}" = "I" ]
  then
    repoFolder="${updatesFolder}${PUBLISH__VERSION:0:2}-I-builds"
    repoName="Integration Build"
  elif [ "${PUBLISH__BUILD_TYPE}" = "S" ]
  then
    repoFolder="${updatesFolder}${PUBLISH__VERSION:0:2}milestones"
    repoName="Milestone"
  else
    repoFolder="${updatesFolder}${PUBLISH__VERSION:0:2}-other"
    repoName="Other"
  fi

  if [ ! -d "${repoFolder}" ]
  then
    mkdir -p ${repoFolder}
  fi

  pushd ${repoFolder}

    buildFolder="${PUBLISH__BUILD_TYPE}${PUBLISH__QUALIFIER:1:8}${PUBLISH__QUALIFIER:10:4}"

    if [ ! -d "${buildFolder}" ]
    then
      mkdir ${buildFolder}
    fi

    curl -s -k ${PUBLISH__BUILD}/artifact/releng/org.eclipse.uml2.build-feature/target/org.eclipse.uml2-${PUBLISH__VERSION}.${PUBLISH__QUALIFIER}.zip > ${localZip}
    unzip ${localZip} -d ${buildFolder}
    rm ${localZip}

    chgrp -R ${group} ${buildFolder}
    chmod -R g+w ${buildFolder}
    ${manageComposite} add -Dchild.repository=${buildFolder} -Dcomposite.name="${projectRepoName} ${PUBLISH__VERSION} ${repoName} Site"

  popd

fi