import { PageHeaderWrapper } from '@ant-design/pro-components';
import React from 'react';
// import { useIntl } from 'umi';

// 自己加props
const Admin: React.FC = (props) => {
  // children就是子页面的信息，详细看路由的routes中定义了子页面
  const { children } = props;
  // const intl = useIntl();
  return (
    <PageHeaderWrapper
    // content={intl.formatMessage({
    //   id: 'pages.admin.subPage.title',
    //   defaultMessage: 'This page can only be viewed by admin',
    // })}
    >
      {children}
    </PageHeaderWrapper>
  );
};

export default Admin;
