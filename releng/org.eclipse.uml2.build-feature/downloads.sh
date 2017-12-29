#!/bin/bash -xv
#
#	Promote the PUBLISH__BUILD to the downloads 'page'.
#
#    PUBLISH__BUILD_TYPE     Build type N/I/S, blank suppresses promotion
#    PUBLISH__BUILD          The base URL of the build to be published, e.g., https://hudson.eclipse.org/uml2/job/mdt-uml2-master/lastSuccessfulBuild/
#    PUBLISH__VERSION        Unqualified version, e.g., 5.4.0
#    PUBLISH__QUALIFIER      Version qualifier, e.g., v20171228-2349
#    PUBLISH__ALIAS          Non blank to use alias as part of final name
#
dropsFolder="/home/data/httpd/download.eclipse.org/modeling/mdt/uml2/downloads/drops/"
group="modeling.mdt.uml2"
zipPrefix="mdt-uml2-Update-"

if [ -n "${PUBLISH__BUILD_TYPE}" ]
then

  tQualifier="${PUBLISH__BUILD_TYPE}${PUBLISH__QUALIFIER:1:8}${PUBLISH__QUALIFIER:10:4}"
  versionFolder="${dropsFolder}${PUBLISH__VERSION}/${tQualifier}"

  if [ ! -d "${versionFolder}" ]
  then
    mkdir -p ${versionFolder}
  fi

  fileStem="${tQualifier}"

  if [ -n "${PUBLISH__ALIAS}" ]
  then
    fileStem=${PUBLISH__ALIAS}
  fi

  zipFile="${zipPrefix}${fileStem}.zip"

  pushd ${versionFolder}
    curl -s -k ${PUBLISH__BUILD}/artifact/releng/org.eclipse.uml2.build-feature/target/org.eclipse.uml2-${PUBLISH__VERSION}.${PUBLISH__QUALIFIER}.zip > ${zipFile}
    curl -s -k ${PUBLISH__BUILD}/consoleText > buildlog.txt    
    md5sum -b ${zipFile} > ${zipFile}.md5
    sha512sum -b ${zipFile} > ${zipFile}.sha1
    # make sure permissions are for the intended group
    chgrp -R ${group} ${zipFile} ${zipFile}.md5 ${zipFile}.sha1
    chmod -R g+w ${zipFile} ${zipFile}.md5 ${zipFile}.sha1
  popd

fi