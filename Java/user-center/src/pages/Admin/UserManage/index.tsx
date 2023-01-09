import {EllipsisOutlined, PlusOutlined} from '@ant-design/icons';
import type {ActionType, ProColumns} from '@ant-design/pro-components';
import {ProTable, TableDropdown} from '@ant-design/pro-components';
import {Button, Dropdown, Image, Tag} from 'antd';
import {useRef} from 'react';
import {getSearchUsers} from "@/services/ant-design-pro/api";


const columns: ProColumns<API.CurrentUser>[] = [
  {
    title: 'ID',
    dataIndex: 'id',
    fixed: 'left',
    width: 50
    // 是否可复制
    // copyable: true,
    // 省略...
    // ellipsis: true,
    // 提示
    // tip: '标题过长会自动收缩',
    // 表单规则
    // formItemProps: {
    //   rules: [
    //     {
    //       required: true,
    //       message: '此项为必填项',
    //     },
    //   ],
    // },
  },
  {
    title: '用户名',
    dataIndex: 'username',
    copyable: true,
    ellipsis: true,
    align: 'right',
    // tip: '标题过长会自动收缩',
  },
  {
    title: '账户',
    dataIndex: 'userAccount',
    ellipsis: true,
    align: 'right',
  },
  {
    title: '头像',
    dataIndex: 'avatarUrl',
    render: (_, record) => (
      <div>
        {/*{JSON.stringify(record)}*/}
        {/*Image是ant design pro提供的标签 更强大*/}
        <Image src={record.avatarUrl} width={100}></Image>
      </div>
    )
  },
  {
    title: '性别',
    dataIndex: 'gender',
    render: (_, record) => <Tag color='blue'>{record.gender == 0 ? '男' : '女'}</Tag>
  },
  {
    title: '手机号',
    dataIndex: 'phone',
  },
  {
    title: '邮箱',
    dataIndex: 'email',
  },
  {
    title: '用户状态',
    dataIndex: 'userStatus',
    render: (_, record) => <Tag color='green'>{record.userStatus == 0 ? '正常' : 'xxx'}</Tag>
  },
  {
    title: '创建时间',
    dataIndex: 'createTime',
    valueType: 'date',
  },
  {
    title: '用户角色',
    dataIndex: 'userRole',
    valueType: 'select',
    valueEnum: {
      0: {text: '普通用户', status: 'Default'},
      1: {text: '管理员', status: 'Success'}
    }
  },
  {
    title: '操作',
    width: 80,
    search: false,
    // key: 'option',
    valueType: 'option',
    fixed: 'right',
    render: (text, record, _, action) => [],
  },
];

export default () => {
  const actionRef = useRef<ActionType>();
  // @ts-ignore
  return (
    <ProTable<API.CurrentUser>
      columns={columns}
      actionRef={actionRef}
      cardBordered
      request={async (params = {}, sort, filter) => {
        console.log(sort, filter);
        const userList = await getSearchUsers();
        return {
          data: userList
        };
      }}
      editable={{
        type: 'multiple',
      }}
      columnsState={{
        persistenceKey: 'pro-table-singe-demos',
        persistenceType: 'localStorage',
        onChange(value) {
          console.log('value: ', value);
        },
      }}
      rowKey="id"
      search={{
        labelWidth: 'auto',
      }}
      options={{
        setting: {
          listsHeight: 400,
        },
      }}
      form={{
        // 由于配置了 transform，提交的参与与定义的不同这里需要转化一下
        syncToUrl: (values, type) => {
          if (type === 'get') {
            return {
              ...values,
              created_at: [values.startTime, values.endTime],
            };
          }
          return values;
        },
      }}
      pagination={{
        pageSize: 5,
        onChange: (page) => console.log(page),
      }}
      dateFormatter="string"
      headerTitle="高级表格"
      toolBarRender={() => [
        <Button key="button" icon={<PlusOutlined/>} type="primary">
          新建
        </Button>,
        <Dropdown
          key="menu"
          menu={{
            items: [
              {
                label: '1st item',
                key: '1',
              },
              {
                label: '2nd item',
                key: '1',
              },
              {
                label: '3rd item',
                key: '1',
              },
            ],
          }}
        >
          <Button>
            <EllipsisOutlined/>
          </Button>
        </Dropdown>,
      ]}
      scroll={{x: 1300}}></ProTable>
  );
};
